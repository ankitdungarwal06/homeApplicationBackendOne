package com.neelkanth.homeApplication.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medicine_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineRecords implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String medicineName;
	@DateTimeFormat(iso=ISO.DATE)
	private Date manufuactureDate;
	@DateTimeFormat(iso=ISO.DATE)
	private Date expiryDate;
	private Boolean isGeneric;
	private Boolean prescribedByDoctor;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "doctorInfo_id")
	private DoctorInfo doctor;
	private String[] usedForIssue;
	private int sachetsBought;
	private int numbersBought;
	private MedicineType medicineType;
	private String boughtFromStoreName;
	private String boughtFromStoreAddress;
	private float priceOneQuantity;
	private float priceOneSachet;
	private String remarks;
	private String[] comments;
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

enum MedicineType{
	TABLET,CAPSULE,SYRUP,INJECTION,OTHERS
}
