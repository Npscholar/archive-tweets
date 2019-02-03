package com.lavish.life.conglomerate.twitter.archive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.lavish.life.conglomerate.twitter.archive.model.Tweet;
import com.lavish.life.conglomerate.twitter.archive.model.response.TwitterTweetsSearchAPIResponse;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TwitterArchiveController {
	
	@Autowired
	private  OAuth2RestTemplate twitterRestTemplate;
	
	private final static String  URL = "https://api.twitter.com/1.1/users/show.json?screen_name=@blessed2breathe";
	private final String twitterAPIBaseURL = "https://api.twitter.com/1.1/";
	private final String searchFullArchive = "tweets/search/fullarchive/prod.json";
	private final String query = "query=from:blessed2breathe&fromDate=201001010000&toDate=201007310000";
	
	@RequestMapping("/")
	public String homePage() {
		ResponseEntity<TwitterTweetsSearchAPIResponse> searchResponse = getTweets();
		log.info("Parsing Response");
		List<Tweet> tweets = searchResponse.getBody().getResults();
		StringBuilder  sb = new StringBuilder();
		tweets.stream().forEach(x -> sb.append(x.getText() + "\n"));
		log.info("Returning Response");
		return sb.toString();
//		ResponseEntity<User> user = twitterRestTemplate.exchange(URL, HttpMethod.GET, entity , User.class);
//		return user.getBody();
//		return "Hello Twitter";
	}

	@RequestMapping("/hello")
	public String helloPage(ModelMap model) {
		ResponseEntity<TwitterTweetsSearchAPIResponse> searchResponse = getTweets();
		model.addAttribute("tweets", searchResponse.getBody().getResults());
		return "hello";
	}
	
	private ResponseEntity<TwitterTweetsSearchAPIResponse> getTweets(){
		log.info("Building Request");
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(twitterAPIBaseURL);
		
		HttpEntity<String> entity = new HttpEntity<String>(new HttpHeaders());
		//System.out.println(twitterRestTemplate.exchange(URL, HttpMethod.GET, entity , User.class));
		log.info("Sending Request");
		return twitterRestTemplate.exchange(builder.path(searchFullArchive).replaceQuery(query).toUriString(), HttpMethod.GET, entity , TwitterTweetsSearchAPIResponse.class);
		
	}
}
