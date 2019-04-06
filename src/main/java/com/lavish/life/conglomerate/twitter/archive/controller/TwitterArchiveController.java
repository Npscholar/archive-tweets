package com.lavish.life.conglomerate.twitter.archive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lavish.life.conglomerate.twitter.archive.data.MongoRepo;
import com.lavish.life.conglomerate.twitter.archive.model.Tweet;
import com.lavish.life.conglomerate.twitter.archive.model.request.TwitterTweetsSearchAPIRequest;
import com.lavish.life.conglomerate.twitter.archive.model.response.TwitterTweetsSearchAPIResponse;
import com.lavish.life.conglomerate.twitter.archive.service.TwitterPremiumSearchService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TwitterArchiveController {
	
	@Autowired
	private  TwitterPremiumSearchService twitterPremiumSearchService;
	
	@Autowired	
	private MongoRepo mongodb;
	
	@RequestMapping("/")
	public String homePage() {
//		log.info("Parsing Response");
//		List<Tweet> tweets = twitterPremiumSearchService.getTweets();
//		
//		try{
//			mongodb.insert(tweets);
//		}catch (MongoBulkWriteException mbwe) {
//			log.error(mbwe.getMessage());
//		}
//		StringBuilder  sb = new StringBuilder();
//		tweets.stream().forEach(x -> sb.append(x.getText() + "\n"));
//		log.info("Returning Response");
		return "hello";	
//		ResponseEntity<User> user = twitterRestTemplate.exchange(URL, HttpMethod.GET, entity , User.class);
//		return user.getBody();
//		return "Hello Twitter";
	}
	
	@PostMapping("/test")
	@ResponseBody
	public TwitterTweetsSearchAPIResponse testPagination(@RequestBody TwitterTweetsSearchAPIRequest tRequest) {
		return twitterPremiumSearchService.getTweets(tRequest).getBody();
	}

	@RequestMapping("/hello")
	public String helloPage(ModelMap model) {
		//get from db 
		List<Tweet> tweetsFromDb = mongodb.findAll();
		model.addAttribute("tweets", tweetsFromDb);
		return "hello";
	}
	
	
}
