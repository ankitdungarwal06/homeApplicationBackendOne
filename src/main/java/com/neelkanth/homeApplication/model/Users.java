package com.neelkanth.homeApplication.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String prefix;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private String bloodGroup;
	private String extra;
	private String email;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String addressLine4;
	private String phoneNo1;
	private String phoneNo2;
	private String phoneNo3;
	private String phoneNo4;
	private String phoneNo5;
}
