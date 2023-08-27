package com.neelkanth.homeApplication.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctorInfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorInfo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumbersOfficial;
	private String phoneNumbersPersonal;
	private String[] addressResidential;
	private String[] addressChamber;
	private String[] hospitalAddresses;
	private String[] reference;
	private String startedFrom;
	@JsonIgnore
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private List<MedicineRecords> medicines;
	private String[] notes;
	private String[] remark;
	private String specialiti;
	private String cityOfPractice;
	private String stateOfPractice;
	private String col1;
	private String col2;
	private String col3;
	private String col4;
	private String col5;
	private String col6;
	private String col7;
	private String col8;
	private String col9;
	private String col10;
	private String col11;
	private String col12;
}
