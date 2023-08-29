package com.neelkanth.homeApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsFromNewAPIResponse {

	// https://newsapi.org/v2/everything?q=India&from=2023-08-27&sortBy=popularity&apiKey=9af0ad515715442abb9996a43cdc90a2

	private String status;
	private int totalResults;
	private Articles[] articles;

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Articles {

	private Source source;
	private String author;
	private String title;
	private String description;
	private String url;
	private String urlToImage;
	private String publishedAt;
	private String content;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Source {
	private String id;
	private String name;
}

