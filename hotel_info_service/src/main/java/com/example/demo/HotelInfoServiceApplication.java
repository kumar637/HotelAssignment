package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.entity.HotelInfo;
import com.example.demo.repo.Hotel_InfoRepositary;

@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories(basePackages = "com.example.demo.repo")
public class HotelInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelInfoServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			@Autowired
			Hotel_InfoRepositary repo;
			
			
			@Override
			public void run(String... args) throws Exception {
				HotelInfo adayarBhavan = new HotelInfo
						(89, "Adayar Bhavan", "valasaravakkam	", "adayar@abc", "veg", "10am-10pm");
				repo.save(adayarBhavan);
			}
		};
	}

}
