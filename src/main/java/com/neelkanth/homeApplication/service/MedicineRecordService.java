package com.neelkanth.homeApplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neelkanth.homeApplication.model.MedicineRecords;
import com.neelkanth.homeApplication.repository.MedicineRepository;

@Service
public class MedicineRecordService {

	@Autowired
	private MedicineRepository medicineRepository;
	
	public List<MedicineRecords> fetchAllMedicine(){
		List<MedicineRecords> res = medicineRepository.findAll();
		System.out.println("res status "+res.size());
		//Stream.of(res).forEach(System.out::println);
		return res;
	}
	
	public MedicineRecords saveRecord(MedicineRecords medicineRecordObject) {
		return medicineRepository.save(medicineRecordObject);
	}
	
	public Void deleteRecord(MedicineRecords medicineRecordObject) {
		medicineRepository.delete(medicineRecordObject);
		Void v = null;
		return v;
	}
	
	public void deleteRecord(Long id) {
		medicineRepository.delete(fetchOnId(id));
	}
	
	public MedicineRecords fetchOnId(Long id) {
		Optional<MedicineRecords> res = Optional.of(medicineRepository.getById(id));
		if(res.isPresent()) {
			return res.get();
		}
		else {
			return new MedicineRecords();
		}
	}

	public List<MedicineRecords> fetchOnSpeciality(String speciality) {
		List<MedicineRecords> responseReceived = fetchAllMedicine();
		List<MedicineRecords> newRecord = new ArrayList<>();
		for(int i=0;i<responseReceived.size();i++) {
			for(String s: responseReceived.get(i).getUsedForIssue()) {
				if(speciality.equalsIgnoreCase(s)) {
					newRecord.add(responseReceived.get(i));
				}
			}
		}
		return newRecord;
	}
}
