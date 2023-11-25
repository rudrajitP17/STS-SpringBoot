package dev.rudrajit.movies;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection="review")
public class Review 
{
	@Id
	public ObjectId id;
	public String body;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Review(ObjectId id, String body) {
		super();
		this.id = id;
		this.body = body;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(String body) {
		super();
		this.body = body;
	}
}
