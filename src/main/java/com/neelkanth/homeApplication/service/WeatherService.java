package com.neelkanth.homeApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neelkanth.homeApplication.model.Weather;
import com.neelkanth.homeApplication.repository.WeatherRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository repository;
	
	public Mono<List<Weather>> fetchAll(){
		return Mono.just(repository.findAll());
	}

	public Weather setRecord(Weather weatherRecord) {
		return repository.save(weatherRecord);
	}
}
