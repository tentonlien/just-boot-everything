package com.example.justbootprometheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JustBootPrometheusApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustBootPrometheusApplication.class, args);
	}

}
