package om.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ContactService;

import entity.Contact;

@RestController
@RequestMapping("/contact")
public class ContactController 
{
	@Autowired
	private ContactService contactservice;
	
	@GetMapping("/user/{userId}")
	public List<Contact> getcontacts(@PathVariable("userId") Long userId)
	{
		return this.contactservice.getcontactofuser(userId);
	}
}
