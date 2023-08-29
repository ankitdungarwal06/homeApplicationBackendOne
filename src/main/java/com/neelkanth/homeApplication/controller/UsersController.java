package com.neelkanth.homeApplication.controller;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neelkanth.homeApplication.entity.AddNewEntity;
import com.neelkanth.homeApplication.model.Users;
import com.neelkanth.homeApplication.service.NamePrefixService;
import com.neelkanth.homeApplication.service.NewsAPINewsService;
import com.neelkanth.homeApplication.service.UserService;

@Controller
public class UsersController {

	@Autowired
	UserService service;
	
	@Autowired
	private NamePrefixService namePrefixService;
	
	@Autowired
	private NewsAPINewsService apiNewsService;
	
	@GetMapping("/")
    public String viewHomePage(Model model) {
		//TODO: planning to show news in index page,, got news api in place,, need to integrate with UI
		//model.addAttribute("news", apiNewsService.fetchNews());
		model. addAttribute("standardDate", new Date());
        return "index";
    }
	
	
	@GetMapping("/users/")
    public String viewHomePageUser(Model model) {
		model.addAttribute("allList", service.showAll());
        return "users/viewUsers";
    }
	
	@GetMapping("/addnew")
    public String addNewEmployee(Model model) {
		AddNewEntity entity = new AddNewEntity();
		entity.setUsers(new Users());
		entity.setNamePrefix(namePrefixService.findAll());
        model.addAttribute("user", entity);
        return "users/newUser";
    }
	
	@PostMapping("/api/v1/createNew/")
	public String createNewEntry(@ModelAttribute("user") AddNewEntity model){
		model.getUsers().setPrefix(model.getSelectedPrefix());
		service.createNew(model.getUsers());
		return "redirect:/";
	}
	
	@GetMapping("/api/v1/findUserById/")
	public ResponseEntity<Users> findById(@RequestParam Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping("/api/v1/deleteUser/{id}")
	public String removeUser(@PathVariable(value = "id") Long id){
		service.removeUser(id);
		return "redirect:/";
	}
}
