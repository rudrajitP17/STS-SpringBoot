package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import entity.Contact;

@Service
public class ContactServiceImp implements ContactService 
{
	List<Contact> list=List.of(
				new Contact(1L,"amit@gmail.com","Amit",1311L),
				new Contact(2L,"bmit@gmail.com","Bmit",1311L),
				new Contact(3L,"cmit@gmail.com","Cmit",1312L),
				new Contact(4L,"dmit@gmail.com","Dmit",1314L)
			);
			
	@Override
	public List<Contact> getcontactofuser(Long userId) 
	{
		return list.stream().filter(contact->contact.getUserId().equals(userId)).collect(Collectors.toList());
	}
	
}
