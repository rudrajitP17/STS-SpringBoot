package dev.rudrajit.movies;

import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

@Service
public class MovieService 
{
	@Autowired
	private Movierepository movierepository;

	public List<Movie> allmovies() 
	{
		System.out.println(movierepository.findAll().toString());
		return movierepository.findAll();
	}
	public Optional<Movie> singleMovie(String imdbId)
	{
		return movierepository.findMovieByImdbId(imdbId);
	}
}
