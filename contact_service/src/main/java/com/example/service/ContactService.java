package com.example.service;

import java.util.List;

import entity.Contact;

public interface ContactService 
{
	public List<Contact> getcontactofuser(Long userId);
}
