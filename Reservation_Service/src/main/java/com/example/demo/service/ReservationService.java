package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Reservation;
import com.example.demo.repo.ReservationRepositary;

@Service(value = "reservationService")
public class ReservationService {
	private ReservationRepositary repo;

	public ReservationService(ReservationRepositary repo) {
		super();
		this.repo = repo;
	}

	public Reservation save(Reservation reservation) {
		return this.repo.save(reservation);

	}

	public List<Reservation> findAllReservation() {
		return this.repo.findAll();
	}

	public Optional<Reservation> findById(int id) {
		return this.repo.findById(id);
	}

	public void deleteById(int id) {
		this.repo.deleteById(id);
	
	}
}
