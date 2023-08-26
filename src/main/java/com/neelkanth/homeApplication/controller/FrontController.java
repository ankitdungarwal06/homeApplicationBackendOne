package com.neelkanth.homeApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neelkanth.homeApplication.model.Weather;
import com.neelkanth.homeApplication.service.WeatherService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class FrontController {

	@Autowired
	private WeatherService service;
	
	@GetMapping("/v1/getAll/")
	public ResponseEntity<Mono<List<Weather>>> fetchAll(){
		return ResponseEntity.ok(service.fetchAll());
	}
	
	@PostMapping("/v1/setWeatherRecord/")
	public ResponseEntity<Weather> setWeather(@RequestBody Weather weatherRecord) {
		System.out.println("User ID: "+weatherRecord.toString());
		System.out.println("received place as "+weatherRecord.getPlace());;
		return ResponseEntity.ok(service.setRecord(weatherRecord));
	}
}
