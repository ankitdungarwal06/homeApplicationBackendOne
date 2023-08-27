package com.neelkanth.homeApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neelkanth.homeApplication.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

}
