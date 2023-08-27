package com.neelkanth.homeApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neelkanth.homeApplication.model.NamePrefix;
import com.neelkanth.homeApplication.repository.NamePrefixRepository;

@Service
public class NamePrefixService {

	@Autowired
	private NamePrefixRepository namePrefixRepository;
	
	public void SavePrefix(NamePrefix prefix) {
		namePrefixRepository.save(prefix);
	}
	
	public void delete(NamePrefix prefix) {
		namePrefixRepository.delete(findPrefixByName(prefix.getPrefix()));
	}
	
	public NamePrefix findPrefixByName(String prefix) {
		Optional<NamePrefix> res = namePrefixRepository.findByPrefix(prefix);
		if(res.isPresent()) {
			return res.get();
		}
		else {
			return new NamePrefix();
		}
	}
	
	public List<NamePrefix> findAll(){
		return namePrefixRepository.findAll();
	}
}
