package com.neelkanth.homeApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.neelkanth.homeApplication.entity.MedicineWithDoctor;
import com.neelkanth.homeApplication.model.MedicineRecords;
import com.neelkanth.homeApplication.service.DoctorService;
import com.neelkanth.homeApplication.service.MedicineRecordService;

@Controller
public class MedicineRecordsController {

	@Autowired
	private MedicineRecordService medicineRecordService;
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/api/v1/createNewMedicineRecord/")
	public String createNewEntry(@ModelAttribute("medicine") MedicineWithDoctor model){
		model.getMedicineRecords().setDoctor(doctorService.fetchById(model.getSelectedDoctor()));
		medicineRecordService.saveRecord(model.getMedicineRecords());
		return "redirect:/";
	}
	
	@GetMapping("/allMedicines/")
    public String viewHomePage(Model model) {
		model.addAttribute("medicineList", medicineRecordService.fetchAllMedicine());
        return "medicine/viewMedicine";
    }
	
	
	@GetMapping("/addNewMedicine/")
    public String addNewMedicine(Model model) {
		MedicineWithDoctor object = new MedicineWithDoctor();
		object.setMedicineRecords(new MedicineRecords());
		object.setDoctor(doctorService.getAll());
        model.addAttribute("medicine", object);
        return "medicine/newMedicine";
    }
	
	@GetMapping("/api/v1/deleteMedicine/{id}")
	public String removeMedicine(@PathVariable(value = "id") Long id){
		medicineRecordService.deleteRecord(id);
		return "redirect:/";
	}
}
