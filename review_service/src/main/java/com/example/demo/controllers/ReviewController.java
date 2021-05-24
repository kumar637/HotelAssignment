package com.example.demo.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Review;
import com.example.demo.service.ReviewService;

@RestController
@RequestMapping(path = "/hotelreview")
@CrossOrigin(origins = "*")
public class ReviewController {
	private ReviewService service;

	public ReviewController(ReviewService service) {
		super();
		this.service = service;
	}

	@PostMapping(path = "/new")
	public Review addReview(@RequestBody Review review) { // -----------> not yet done
		return this.service.save(review);

	}

	@GetMapping(path = "/srch/id/{id}")
	public Optional<Review> getById(@PathVariable("id") int id) { // -----------> done
		return this.service.findById(id);
	}

	@GetMapping(path = "/srch/reviews")
	public List<Review> getAllReview() { // -----------> done
		return this.service.findAllReview();
	}

	@DeleteMapping(path = "/delete/{id}")
	public Review deleteById(@PathVariable("id") int id) {
		Optional<Review> entity = this.service.findById(id);
		Review delete = null;
		if (entity.isPresent()) {
			delete = entity.get();
			this.service.deleteById(id);

		} else {
			throw new NoSuchElementException("Delete Id is empty");

		}
		return delete;

	}
}