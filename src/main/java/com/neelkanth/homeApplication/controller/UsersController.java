package com.neelkanth.homeApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neelkanth.homeApplication.model.Users;
import com.neelkanth.homeApplication.service.UserService;

@RestController
public class UsersController {

	@Autowired
	UserService service;
	
	@PostMapping("/api/v1/createNew/")
	public ResponseEntity<Users> createNewEntry(@RequestBody Users model){
		return ResponseEntity.ok(service.createNew(model));
	}
	
	@GetMapping("/api/v1/findUserById/")
	public ResponseEntity<Users> findById(@RequestParam Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@DeleteMapping("/api/v1/deleteUser/")
	public ResponseEntity<Void> removeUser(@RequestBody Users model){
		return ResponseEntity.ok(service.removeUser(model));
	}
	
}
