package com.neelkanth.homeApplication.entity;

import java.util.List;

import com.neelkanth.homeApplication.model.NamePrefix;
import com.neelkanth.homeApplication.model.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainEntity {
	private List<Users> users;
	private List<NamePrefix> namePrefix;
}
