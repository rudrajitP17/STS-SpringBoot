package dev.rudrajit.movies;

import java.util.List;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController 
{
	@Autowired
	private MovieService movieservice;
	@GetMapping
	public ResponseEntity<List<Movie>> getAllmovies()
	{
		return new ResponseEntity<List<Movie>>(movieservice.allmovies(),HttpStatus.OK);
	}
	@GetMapping("/{imdbId}")
	public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId)
	{
		return new ResponseEntity<Optional<Movie>>(movieservice.singleMovie(imdbId),HttpStatus.OK);
	}
}
