package com.neelkanth.homeApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neelkanth.homeApplication.model.Users;
import com.neelkanth.homeApplication.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public Users createNew(Users model) {
		return repository.save(model);
	}
	
	public Users findById(Long id) {
		Optional<Users> found = repository.findById(id);
		if(found.isPresent()) {
			return found.get();
		}
		else {
			return new Users();
		}
	}
	
	public Void removeUser(Long id) {
		repository.delete(findById(id));
		Void v = null;
		return v;
	}
	
	public List<Users> showAll(){
		return repository.findAll();
	}
}
