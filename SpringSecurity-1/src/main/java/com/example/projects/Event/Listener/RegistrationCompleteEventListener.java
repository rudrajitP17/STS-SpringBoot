package com.example.projects.Event.Listener;


import java.util.UUID;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.projects.Entity.User;
import com.example.projects.Event.RegistrationCompleteEvent;
import com.example.projects.Service.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> 
{
	@Autowired
	private UserService userService;
	
	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) 
	{
		User user=event.getUser();
		String token=UUID.randomUUID().toString();
		userService.saveVerificationTokenForUser(token,user);
		String url=event.getApplicationUrl()+"/verifyRegistration?token="+token;
		System.out.println("Click on the link to verify your account: {}"+url);
	}
}
