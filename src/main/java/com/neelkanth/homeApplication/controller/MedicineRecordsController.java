package com.neelkanth.homeApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.neelkanth.homeApplication.model.MedicineRecords;
import com.neelkanth.homeApplication.service.MedicineRecordService;

@Controller
public class MedicineRecordsController {

	@Autowired
	private MedicineRecordService medicineRecordService;
	
	@PostMapping("/api/v1/createNewMedicineRecord/")
	public String createNewEntry(@ModelAttribute("medicine") MedicineRecords model){
		medicineRecordService.saveRecord(model);
		return "redirect:/";
	}
	
	@GetMapping("/allMedicines/")
    public String viewHomePage(Model model) {
		model.addAttribute("medicineList", medicineRecordService.fetchAllMedicine());
        return "viewMedicine";
    }
	
	
	@GetMapping("/addNewMedicine/")
    public String addNewMedicine(Model model) {
		MedicineRecords record = new MedicineRecords();
        model.addAttribute("medicine", record);
        return "newMedicine";
    }
	
	@GetMapping("/api/v1/deleteMedicine/{id}")
	public String removeMedicine(@PathVariable(value = "id") Long id){
		medicineRecordService.deleteRecord(id);
		return "redirect:/";
	}
}
