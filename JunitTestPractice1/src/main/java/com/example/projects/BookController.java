package com.example.projects;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookRepository bookRepository;
	
	@GetMapping
	public List<Book> getAllBookRecords(){
		return bookRepository.findAll();
	}
	@GetMapping("{bookId}")
	public Book getBookById(@PathVariable("bookId") Long bookId) {
		return bookRepository.findById(bookId).get();
	}
	@PostMapping
	public Book createBookRecord(@RequestBody Book bookRecord) {
		return bookRepository.save(bookRecord);
	}
	@PutMapping
	public Book updateBookRecord(@RequestBody Book bookRecord)throws NotFoundException {
		if(bookRecord==null || bookRecord.getBookId()==null)
			throw new NotFoundException();
		Optional<Book> optionalBook=bookRepository.findById(bookRecord.getBookId());
		if(!optionalBook.isPresent()) 
			throw new NotFoundException();
		Book existingBookRecord=optionalBook.get();
		existingBookRecord.setName(bookRecord.getName());
		existingBookRecord.setSummary(bookRecord.getSummary());
		existingBookRecord.setRating(bookRecord.getRating());
		
		return  bookRepository.save(existingBookRecord);
	}
}
