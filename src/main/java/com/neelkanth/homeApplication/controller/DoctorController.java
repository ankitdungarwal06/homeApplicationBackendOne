package com.neelkanth.homeApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.neelkanth.homeApplication.model.DoctorInfo;
import com.neelkanth.homeApplication.service.DoctorService;

@Controller
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/api/v1/createNewDoctor/")
	public String createNewEntry(@ModelAttribute("doctor") DoctorInfo model){
		doctorService.save(model);
		return "redirect:/";
	}
	
	@GetMapping("/allDocs/")
    public String viewHomePage(Model model) {
		model.addAttribute("doctorList", doctorService.getAll());
        return "indexDoctor";
    }
	
	
	@GetMapping("/addNewDoctor")
    public String addNewDoctor(Model model) {
		DoctorInfo doctorObj = new DoctorInfo();
        model.addAttribute("doctor", doctorObj);
        return "newDoctor";
    }
	
	@GetMapping("/api/v1/deleteDoctor/{id}")
	public String removeDoctor(@PathVariable(value = "id") Long id){
		doctorService.remove(id);
		return "redirect:/";
	}
}
