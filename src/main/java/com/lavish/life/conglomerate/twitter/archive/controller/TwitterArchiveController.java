package com.lavish.life.conglomerate.twitter.archive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.lavish.life.conglomerate.twitter.archive.model.Tweet;
import com.lavish.life.conglomerate.twitter.archive.model.response.TwitterTweetsSearchAPIResponse;

@RestController
public class TwitterArchiveController {
	
	@Autowired
	private  OAuth2RestTemplate twitterRestTemplate;
	
	private final static String  URL = "https://api.twitter.com/1.1/users/show.json?screen_name=@blessed2breathe";
	private final String twitterAPIBaseURL = "https://api.twitter.com/1.1/";
	private final String searchFullArchive = "tweets/search/fullarchive/prod.json";
	private final String query = "query=from:blessed2breathe&fromDate=201001010000&toDate=201007310000";
	
	@RequestMapping("/")
	public String homePage() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(twitterAPIBaseURL);
		
		HttpEntity<String> entity = new HttpEntity<String>(new HttpHeaders());
		//System.out.println(twitterRestTemplate.exchange(URL, HttpMethod.GET, entity , User.class));
		ResponseEntity<TwitterTweetsSearchAPIResponse> searchResponse = twitterRestTemplate.exchange(builder.path(searchFullArchive).replaceQuery(query).toUriString(), HttpMethod.GET, entity , TwitterTweetsSearchAPIResponse.class);
		List<Tweet> tweets = searchResponse.getBody().getResults();
		StringBuilder  sb = new StringBuilder();
		tweets.stream().forEach(x -> sb.append(x.getText() + "\n"));
		return sb.toString();
//		ResponseEntity<User> user = twitterRestTemplate.exchange(URL, HttpMethod.GET, entity , User.class);
//		return user.getBody();
//		return "Hello Twitter";
	}

}
