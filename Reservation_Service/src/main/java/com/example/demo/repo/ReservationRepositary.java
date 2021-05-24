package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Reservation;

public interface ReservationRepositary extends MongoRepository<Reservation, Integer> {
	

}
