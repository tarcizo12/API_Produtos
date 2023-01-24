package com.api.produto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "model")
@SpringBootApplication
public class CrudApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
