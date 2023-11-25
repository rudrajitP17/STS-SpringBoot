package dev.rudrajit.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService 
{
	@Autowired
	private ReviewRepository reviewrepository;
	@Autowired
	private MongoTemplate mongotemplate;
	
	public Review createReview(String reviewBody,String imdbId)
	{
		Review review=reviewrepository.insert(new Review(reviewBody));
		
		mongotemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId))
		.apply(new Update().push("reviewIds").value(review)).first();
		
		return review;
	}
}
