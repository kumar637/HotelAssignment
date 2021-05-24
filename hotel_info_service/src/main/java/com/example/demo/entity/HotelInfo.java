package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "hotelMangaement")
public class HotelInfo {
	@Id
	private int id;

	private String name;

	private String serviceArea;

	private String emailAddress;

	private String menuType;

	private String openingHours;
	

}



 


