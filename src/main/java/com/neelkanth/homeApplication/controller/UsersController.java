package com.neelkanth.homeApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neelkanth.homeApplication.model.Users;
import com.neelkanth.homeApplication.service.UserService;

@Controller
public class UsersController {

	@Autowired
	UserService service;
	
	
	@GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("allUserslist", service.showAll());
        return "index";
    }
	
	@GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "newUser";
    }
	
	@PostMapping("/api/v1/createNew/")
	public String createNewEntry(@ModelAttribute("user") Users model){
		service.createNew(model);
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
