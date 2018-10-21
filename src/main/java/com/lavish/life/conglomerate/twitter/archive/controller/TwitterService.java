package com.lavish.life.conglomerate.twitter.archive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TwitterService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String BEARER_TOKEN = "Basic cHV1UGNOUzVuUFF0M3NBSGx1T3FyMGlkMzp5M1JyYzBsVERNQzRCOUF3NlBhNTc4VjFRUlhwQzN1c1dwR1NjYk03d2lvb0JPTTIwYg==";
	
	
	public ResponseEntity<String> getTweets(){
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		headers.add(HttpHeaders.AUTHORIZATION, BEARER_TOKEN);
		
		HttpEntity<String> body = new HttpEntity<String>("grant_type=client_credentials", headers);
		
		return null;
	}

}
