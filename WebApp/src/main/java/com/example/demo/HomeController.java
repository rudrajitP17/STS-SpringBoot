package com.example.demo;

import java.net.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController 
{
//	@RequestMapping("Home")
//	public String home(HttpServletRequest req,HttpServletResponse resp)
//	{
//		System.out.println("HI");
//		HttpSession session=req.getSession();
//		String name=req.getParameter("name");
//		System.out.println("Hi "+name);
//		session.setAttribute("name", name);
//		return "Home";
//	}
//This is via req, res and session objects, if we don't want to use any of them, we can use ModelAndView class
//	@RequestMapping("Home")
//	public ModelAndView home(@RequestParam("name1") String myName)
//	{
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("name1",myName);
//		mv.setViewName("Home");
//		return mv;
//	}
//Model view class for one parameter.
	@RequestMapping("Home")
	public ModelAndView home(Alien a)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("obj", a);
		mv.setViewName("Home");
		return mv;
	}
}
