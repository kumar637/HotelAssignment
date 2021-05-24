package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "hotelReservation")
public class Reservation {
	@Id
	private int id; 
	private LocalDateTime reservationDate; 
	private int userId; 
	private int partySize; 

}
