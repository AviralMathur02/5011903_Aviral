package com.laraib.bookstoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.lara.bookstoreapi.repository")
@EntityScan(basePackages = "com.lara.bookstoreapi.model")
public class BookstoreapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreapiApplication.class, args);
	}

}