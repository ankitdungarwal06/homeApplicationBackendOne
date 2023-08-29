package com.neelkanth.homeApplication.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsFromNewAPIRequest {

	//https://newsapi.org/v2/everything?q=India&from=2023-08-27&sortBy=popularity&apiKey=9af0ad515715442abb9996a43cdc90a2
	private String q; //=India&
	private String from; //=2023-08-27&
	private String sortBy; //=popularity&
	private String apiKey; //=9af0ad515715442abb9996a43cdc90a2
}
