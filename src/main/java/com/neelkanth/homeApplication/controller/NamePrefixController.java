package com.neelkanth.homeApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.neelkanth.homeApplication.service.NamePrefixService;

@Controller
public class NamePrefixController {

	@Autowired
	private NamePrefixService namePrefixService;
	
	@GetMapping("/prefix")
    public String viewAllPrefix(Model model) {
        model.addAttribute("allPrefixlist", namePrefixService.findAll());
        return "prefix";
    }
}
