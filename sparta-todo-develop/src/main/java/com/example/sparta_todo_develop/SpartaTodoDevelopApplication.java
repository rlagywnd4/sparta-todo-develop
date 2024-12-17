package com.example.sparta_todo_develop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpartaTodoDevelopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpartaTodoDevelopApplication.class, args);
	}

}