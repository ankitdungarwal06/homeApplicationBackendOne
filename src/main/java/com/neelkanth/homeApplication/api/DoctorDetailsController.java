package com.neelkanth.homeApplication.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neelkanth.homeApplication.model.DoctorInfo;
import com.neelkanth.homeApplication.service.DoctorService;


@RequestMapping
@RestController
@CrossOrigin
public class DoctorDetailsController {

	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/getAllDoctors/")
	public ResponseEntity<List<DoctorInfo>> fetchAllDoctors(){
		return ResponseEntity.ok(doctorService.getAll());
	}
	
	@GetMapping("/getDoctorById/")
	public ResponseEntity<DoctorInfo> fetchDoctorById(@RequestParam("id")Long id){
		return ResponseEntity.ok(doctorService.fetchById(id));
	}
	
	@GetMapping("/getDoctorByFirstName/")
	public ResponseEntity<List<DoctorInfo>> fetchDoctorByFirstName(@RequestParam("firstName") String firstName){
		return ResponseEntity.ok(doctorService.fetchByName(firstName));
	}
	
	@GetMapping("/getDoctorBySpeciality/")
	public ResponseEntity<List<DoctorInfo>> fetchDoctorBySpeciality(@RequestParam("speciality") String speciality){
		return ResponseEntity.ok(doctorService.fetchBySpeciality(speciality));
	}
	
	//save doctor
	@PostMapping("/saveDoctor/")
	public ResponseEntity<DoctorInfo> saveDoctor(@RequestBody DoctorInfo doctorObject){
		return ResponseEntity.ok(doctorService.save(doctorObject));
	}
	
	//modify doctor
	@PostMapping("/updateDoctor/")
	public ResponseEntity<DoctorInfo> updateDoctor(@RequestBody DoctorInfo doctorObject){
		return ResponseEntity.ok(doctorService.modify(doctorObject));
	}
	
	//delete doctor
//	@DeleteMapping("/removeDoctorRecord/")
//	public ResponseEntity<Void> removeDoctorRecord(@RequestBody DoctorInfo doctorObject){
//		return ResponseEntity.ok(doctorService.remove(doctorObject));
//	}
}
