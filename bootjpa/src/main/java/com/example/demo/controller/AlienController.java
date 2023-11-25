package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Alien;

import boot.example.demo.Dao.AlienRepo;

@RestController
@EnableJpaRepositories("boot.example.demo.Dao")
public class AlienController 
{
	@Autowired
	AlienRepo repo;
	@RequestMapping("Home")
	public String home()
	{
		return "Home.jsp";
	}
	@RequestMapping("/addalien")
	public String addalien(Alien a)
	{
		repo.save(a);
		return "Home.jsp";
	}
	@DeleteMapping("/alien/{aid}")
	public String delete(@PathVariable("aid") int aid)
	{
		Alien a=repo.getById(aid);
		repo.delete(a);
		return "deleted";
	}
	@PostMapping(path="/alien",consumes={"application/json"})
	public String addalien1(Alien a)
	{
		repo.save(a);
		return "Home.jsp";
	}
	@PutMapping(path="/alien",consumes={"application/json"})
	public String SaveorUpdate(Alien a)
	{
		repo.save(a);
		return "Home.jsp";
	}
	@GetMapping("/aliens")
	public List<Alien> getAllaliens()
	{
		return repo.findAll();
	}
	@RequestMapping(path="/aliens/{aid}")//produces= {"application/xml"}
	public Optional<Alien> getAlien(@PathVariable("aid") int aid)
	{
		return repo.findById(aid);
	}
//	@RequestMapping("/getalien")
//	public ModelAndView addalien(@RequestParam int aid)
//	{
//		ModelAndView mv=new ModelAndView();
//		Alien a1=repo.findById(aid).orElse(new Alien());
//		System.out.println(repo.findByAtech("Java"));
//		System.out.println(repo.findByAidGreaterThan(102));
//		System.out.println(repo.findByAtechSorted("Java"));
//		mv.addObject("obj", a1);
//		mv.setViewName("Show.jsp");
//		return mv;
//	}

}
