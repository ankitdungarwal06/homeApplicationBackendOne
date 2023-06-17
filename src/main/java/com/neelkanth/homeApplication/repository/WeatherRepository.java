package com.neelkanth.homeApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neelkanth.homeApplication.model.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long>{

}
