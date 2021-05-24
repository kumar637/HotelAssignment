package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.entity.Review;
import com.example.demo.repo.ReviewRepositary;

@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories(basePackages = "com.example.demo.repo")
public class ReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			@Autowired
			ReviewRepositary repo;
			
			
			@Override
			public void run(String... args) throws Exception {
				Review cust1 = new Review(1, "Adyar Bhavan", "kumar", "about taste", "the taste and service is nice", 8);
				repo.save(cust1);
			}
		};
	}

}
