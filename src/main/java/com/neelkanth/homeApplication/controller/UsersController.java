package com.neelkanth.homeApplication.controller;

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
import com.neelkanth.homeApplication.service.UserService;

@Controller
public class UsersController {

	@Autowired
	UserService service;
	
	@Autowired
	private NamePrefixService namePrefixService;
	
	@GetMapping("/")
    public String viewHomePage(Model model) {
		//model.addAttribute("allList", service.showAll());
        return "index";
    }
	
	
	@GetMapping("/users/")
    public String viewHomePageUser(Model model) {
		model.addAttribute("allList", service.showAll());
        return "indexUsers";
    }
	
	@GetMapping("/addnew")
    public String addNewEmployee(Model model) {
		AddNewEntity entity = new AddNewEntity();
		entity.setUsers(new Users());
		entity.setNamePrefix(namePrefixService.findAll());
        model.addAttribute("user", entity);
        return "newUser";
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
