package com.neelkanth.homeApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neelkanth.homeApplication.model.MedicineRecords;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineRecords, Long> {

}
