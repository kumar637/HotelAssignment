package com.example.demo.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Reservation;
import com.example.demo.service.ReservationService;

@RestController
@RequestMapping(path = "/hotelreservation/")
@CrossOrigin(origins = "*")
public class ReservationController {
	private ReservationService service;

	public ReservationController(ReservationService service) {
		super();
		this.service = service;
	}

	@PostMapping(path = "/new")
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reserve) {   // -----------> not yet done
	Reservation value =	this.service.save(reserve);
	return ResponseEntity.status(HttpStatus.CREATED).body(value);
		
	}
	@GetMapping(path = "/srch/id/{id}")
	public Optional<Reservation> getById(@PathVariable("id") int id) {       // -----------> done
		Optional<Reservation> value =  this.service.findById(id);
		if(value==null)
			throw new RuntimeException("Reservation not Found");
		return value;
		
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public Reservation deleteById(@PathVariable("id") int id) {
		Optional<Reservation> entity = service.findById(id);
		Reservation delete =null;
		if(entity.isPresent()) {
			delete =entity.get();
			this.service.deleteById(id);
		}else {
			throw new NoSuchElementException("delete Id is empty");
			
		}
		return delete;
		
	}
	@GetMapping(path = "/srch/reservations")
	public List<Reservation> getAllReservation(){                            // -----------> done
		List<Reservation> resvalue = 	this.service.findAllReservation();
		if(resvalue==null)
			throw new RuntimeException("Reservation Not Found");
		return resvalue;
	}
		
	
	
	
	
}


