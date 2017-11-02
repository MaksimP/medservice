package org.medservice.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
       Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        authorities.forEach(authority -> {
            if (authority.getAuthority().equals("ADMIN")) {
                try {
                    redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/admin");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/patients_table");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}