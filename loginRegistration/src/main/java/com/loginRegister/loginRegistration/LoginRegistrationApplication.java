package com.loginRegister.loginRegistration;

import com.loginRegister.loginRegistration.Config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LoginRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginRegistrationApplication.class, args);
	}

}
