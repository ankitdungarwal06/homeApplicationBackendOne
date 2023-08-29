package com.neelkanth.homeApplication.service;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neelkanth.homeApplication.entity.NewsFromNewAPIResponse;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.http.HttpResponse;

@Service
public class NewsAPINewsService {

	@Value("${newsAPI.q:India}")
	private String q;
	@Value("${newsAPI.from:2023-08-27}")
	private String from;
	@Value("${newsAPI.sortBy:popularity}")
	private String sortBy;
	@Value("${newsAPI.apiKey:9af0ad515715442abb9996a43cdc90a2}")
	private String apiKey;

	private String url = "https://newsapi.org/v2/everything?q=";

	public NewsFromNewAPIResponse fetchNews() {
		NewsFromNewAPIResponse responseData = null;
		NewsFromNewAPIResponse toRes = new NewsFromNewAPIResponse();
		String formatUrl = url + q + "&from=" + from + "&sortBy=" + sortBy + "&apiKey=" + apiKey;
		try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(formatUrl);
            
            HttpResponse response = httpClient.execute(request);
            
            ObjectMapper objectMapper = new ObjectMapper();
            responseData = objectMapper.readValue(response.getEntity().getContent(), NewsFromNewAPIResponse.class);
            httpClient.close();
            
            System.out.println("Name: " + responseData.getTotalResults());
            // Access other fields as needed
            
            return responseData;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return responseData;
	}
	
//	public void fetchNews() {
//		// https://newsapi.org/v2/everything?q=India&from=2023-08-27&sortBy=popularity&apiKey=9af0ad515715442abb9996a43cdc90a2
//		String formatUrl = url + q + "&from=" + from + "&sortBy=" + sortBy + "&apiKey=" + apiKey;
//		try {
//			// Create a URL object with the endpoint you want to request
//			URL url = new URL(formatUrl);
//
//			// Open a connection to the URL
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//			// Set the request method (GET in this case)
//			connection.setRequestMethod("GET");
//
//			// Get the response code
//			int responseCode = connection.getResponseCode();
//			System.out.println("Response Code: " + responseCode);
//
//			// Read the response data
//			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			String inputLine;
//			StringBuilder response = new StringBuilder();
//
//			while ((inputLine = in.readLine()) != null) {
//				response.append(inputLine);
//			}
//			in.close();
//
//			// Print the response
//			System.out.println("Response Data:\n" + response.toString());
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
