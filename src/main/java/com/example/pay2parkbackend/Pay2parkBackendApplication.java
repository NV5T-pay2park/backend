package com.example.pay2parkbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Pay2parkBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pay2parkBackendApplication.class, args);
	}

}
