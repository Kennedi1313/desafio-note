package com.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.desafio.model" })
@EnableJpaRepositories(basePackages = { "com.desafio.repository" })
@ComponentScan(basePackages = {"com.desafio.controller"})

public class DesafioApplication {
	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

}
