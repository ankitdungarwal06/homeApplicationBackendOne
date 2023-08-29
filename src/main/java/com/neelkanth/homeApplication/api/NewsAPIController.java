package com.neelkanth.homeApplication.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neelkanth.homeApplication.entity.NewsFromNewAPIResponse;
import com.neelkanth.homeApplication.service.NewsAPINewsService;

@RequestMapping
@RestController
@CrossOrigin
public class NewsAPIController {

	@Autowired
	private NewsAPINewsService apiNewsService;
	
	@GetMapping("/api/news/")
	public NewsFromNewAPIResponse fetchNews() {
		return apiNewsService.fetchNews();
	}
}
