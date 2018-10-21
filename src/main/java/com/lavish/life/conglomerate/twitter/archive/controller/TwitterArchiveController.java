package com.lavish.life.conglomerate.twitter.archive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lavish.life.conglomerate.twitter.archive.model.User;

@RestController
public class TwitterArchiveController {
	
	@Autowired
	private  OAuth2RestTemplate twitterRestTemplate;
	
	private final static String  URL = "https://api.twitter.com/1.1/users/show.json?screen_name=@blessed2breathe";
	
	@RequestMapping("/")
	public ResponseEntity<User > homePage() {
		
		HttpEntity<String> entity = new HttpEntity<String>(new HttpHeaders());
		
		return twitterRestTemplate.exchange(URL, HttpMethod.GET, entity , User.class);
//		return "Hello Twitter";
	}

}
