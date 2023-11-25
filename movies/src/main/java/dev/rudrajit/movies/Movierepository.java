package dev.rudrajit.movies;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface Movierepository extends MongoRepository<Movie, ObjectId> 
{
	Optional<Movie> findMovieByImdbId(String imdbId);
}
