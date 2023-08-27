package com.neelkanth.homeApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neelkanth.homeApplication.model.NamePrefix;

public interface NamePrefixRepository extends JpaRepository<NamePrefix, Long>{

	Optional<NamePrefix> findByPrefix(String prefix);
}
