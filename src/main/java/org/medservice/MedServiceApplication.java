package org.medservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.SimpleCommandLinePropertySource;

@SpringBootApplication
public class MedServiceApplication {

	public static final String SPRING_PROFILE_PRODUCTION = "prod";
	public static final String SPRING_PROFILE_DEVELOPMENT = "dev";

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(MedServiceApplication.class);
		SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
		if (source.containsProperty("spring.profiles.active")) {
			application.setAdditionalProfiles(SPRING_PROFILE_PRODUCTION);
		} else {
			application.setAdditionalProfiles(SPRING_PROFILE_DEVELOPMENT);
		}
		application.run(args);
	}
}
