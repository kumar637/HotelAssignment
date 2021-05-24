package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.entity.Reservation;
import com.example.demo.repo.ReservationRepositary;

@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories(basePackages = "com.example.demo.repo")
public class ReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			@Autowired
			ReservationRepositary repo;
			
			@Override
			public void run(String... args) throws Exception {
				Reservation reserve1 = new Reservation(12, LocalDateTime.now(), 6076, 2);
				repo.save(reserve1);
				
			}
		};
	}

}
