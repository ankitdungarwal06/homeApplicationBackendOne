package com.neelkanth.homeApplication.entity;

import java.util.List;

import com.neelkanth.homeApplication.model.DoctorInfo;
import com.neelkanth.homeApplication.model.MedicineRecords;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineWithDoctor {
	private MedicineRecords medicineRecords;
	private List<DoctorInfo> doctor;
	private Long selectedDoctor;
}
