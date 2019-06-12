package com.phinacio.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class HelpdeskApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}
}
