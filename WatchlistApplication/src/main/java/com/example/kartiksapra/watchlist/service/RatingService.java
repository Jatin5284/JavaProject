package com.example.kartiksapra.watchlist.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingService {

	String apiUrl="http://www.omdbapi.com/?i=tt3896198&apikey=cd61dc16";

	public String getMovieRating(String title) {
		// TODO Auto-generated method stub

		try {
			// try to fetch the rating by calling omdb api
			RestTemplate template = new RestTemplate();
			//apiUrl + title
			
			ResponseEntity<ObjectNode> response = template.getForEntity(apiUrl + title, ObjectNode.class);
			
			ObjectNode jsonObject = response.getBody();
			System.out.println(jsonObject.path("imdbRating").asText());
			return jsonObject.path("imdbRating").asText();
		} catch(Exception e) {
			//to user entered rating will be taken
			System.out.println("Either movie name not available or api is down" + e.getMessage());
			return null;
		}
	}
}
