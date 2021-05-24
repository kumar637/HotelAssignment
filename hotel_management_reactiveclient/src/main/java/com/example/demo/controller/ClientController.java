package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClientController {
	private WebClient client;

	public ClientController(WebClient client) {
		super();
		this.client = client;
	}
	
	/////////////////For Hotel-Info/////////////////////
	
	@GetMapping(path = "client/hotels")
	public Flux<String> getAllHotels(){
		
		return client.get().uri("http://HOTEL-INFO/hotelinfo/hotels").retrieve().bodyToFlux(String.class);
	}
	
	@GetMapping(path = "client/srch/areas/{area}")
	public Mono<String> getByarea(@PathVariable("area") String area){
		return client.get().uri("http://HOTEL-INFO/hotelinfo/srch/areas/"+ area).retrieve().bodyToMono(String.class);
	}
	
	@GetMapping(path = "client/srch/names/{names}")
	public Mono<String> getByName(@PathVariable("names") String name){
		return client.get().uri("http://HOTEL-INFO/hotelinfo/srch/areas/"+ name).retrieve().bodyToMono(String.class);
	}
	
	@GetMapping(path = "client/srch/menuTypes/{menu}")
	public Mono<String> getByMenuTypes(@PathVariable("menu") String menu){
		return client.get().uri("http://HOTEL-INFO/hotelinfo/srch/areas/"+ menu).retrieve().bodyToMono(String.class);
	}
	
	@PostMapping(path = "client/newInfo")
	public Mono<String> addHotelInfo(@RequestBody String value){
		return client.post().uri("http://HOTEL-INFO/hotelinfo/new").
				contentType(MediaType.APPLICATION_JSON).bodyValue(value).retrieve().bodyToMono(String.class);
	}
	
	@DeleteMapping(path = "client/deleteInfo/{id}")
	public Mono<String> deleteById(@PathVariable("id") int id){
		return client.delete().uri("http://HOTEL-INFO/hotelinfo/delete/"+id).retrieve().bodyToMono(String.class);
	}
	 
	@PutMapping(path = "client/update/{id}")
	public Mono<String> updateById(@PathVariable("id") int id,@RequestBody String value1){
		return client.put().uri("http://HOTEL-INFO/hotelinfo/").contentType(MediaType.APPLICATION_JSON).bodyValue(value1).retrieve().bodyToMono(String.class);
	}
//  <<<<<<<<<<<<<<<<<For Hotel Reservation>>>>>>>>>>>>>>>>>>
	
	@GetMapping(path = "client/srch/reservationId/{id}")
	public Mono<String> getById(@PathVariable("id") int id){
		return client.get().uri("http://HOTEL-RESERVATION/hotelreservation/srch/id/"+id).retrieve().bodyToMono(String.class);
	}
	@GetMapping(path = "client/reservations")
	public Flux<String> getAllReservation(){
		return client.get().uri("http://HOTEL-RESERVATION/hotelreservation/srch/reservations").retrieve().bodyToFlux(String.class);
				
		
	}
	@PostMapping(path = "client/newReservation")
	public Mono<String> addReservation(@RequestBody String value){
		return client.post().uri("http://HOTEL-RESERVATION/hotelreservation/new")
				.contentType(MediaType.APPLICATION_JSON).bodyValue(value).retrieve().bodyToMono(String.class);
		
	}
	
//  ********************** For Hotel Review *******************
	
	@GetMapping(path = "client/srch/reviewId/{id}")
	public Mono<String> getByreviewId(@PathVariable("id") int id){
		return client.get().uri("http://HOTEL-REVIEW/hotelreview/srch/id/"+id).retrieve().bodyToMono(String.class);
	}
	@GetMapping(path = "client/reviews")
	public Flux<String> getAllReview(){
		return client.get().uri("http://HOTEL-REVIEW/hotelreview/srch/reviews").retrieve().bodyToFlux(String.class);
				
		
	}
	@PostMapping(path = "client/newReview")
	public Mono<String> addReview(@RequestBody String value){
		return client.post().uri("http://HOTEL-RESERVATION/hotelreservation/new")
				.contentType(MediaType.APPLICATION_JSON).bodyValue(value).retrieve().bodyToMono(String.class);
		
	}
}
