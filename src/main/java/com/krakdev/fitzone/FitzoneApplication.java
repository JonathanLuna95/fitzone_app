package com.krakdev.fitzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.krakdev.fitzone")
@EnableJpaRepositories(basePackages = "com.krakdev.fitzone")
@EntityScan(basePackages = "com.krakdev.fitzone")


public class FitzoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitzoneApplication.class, args);
	}

}
