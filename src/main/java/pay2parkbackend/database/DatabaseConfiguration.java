package com.example.pay2parkbackend.database;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.example.pay2parkbackend.repositories"})
public class DatabaseConfiguration {

}