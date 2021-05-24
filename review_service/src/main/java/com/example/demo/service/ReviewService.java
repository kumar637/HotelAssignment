package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repo.ReviewRepositary;

@Service(value = "revieService")
public class ReviewService {
	private ReviewRepositary repo;

	public ReviewService(ReviewRepositary repo) {
		super();
		this.repo = repo;
	}

	public Review save(Review review) {
		return this.repo.save(review);

	}

	public List<Review> findAllReview() {
		return this.repo.findAll();
	}

	public Optional<Review> findById(int id) {
		return this.repo.findById(id);
	}

	public void deleteById(int id) {
		this.repo.deleteById(id);
		
	}

}
