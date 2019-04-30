package com.org.cicforumspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CicforumspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CicforumspringbootApplication.class, args);
	}

}
