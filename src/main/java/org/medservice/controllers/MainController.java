package org.medservice.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "redirect:login";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model, Authentication authentication) {
        if (authentication != null) {
            final String[] authority = new String[1];
            authentication.getAuthorities().stream().forEach(a -> {
                authority[0] = a.getAuthority();
            });
            if (authority[0].equals("ADMIN")) {
                return "redirect:admin";
            } else {
                return "redirect:patients_table";
            }
        }
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @GetMapping("/department")
    public String department(Model model) {
        return "department";
    }
}



