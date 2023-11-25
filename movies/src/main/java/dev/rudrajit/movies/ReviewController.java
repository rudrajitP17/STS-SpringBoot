package dev.rudrajit.movies;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController 
{
	@Autowired
	private ReviewService reviewservice;
	@PostMapping
	public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload)
	{
		return new ResponseEntity<Review>(reviewservice.createReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);
	}
}
