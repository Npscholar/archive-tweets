/**
 * 
 */
package com.lavish.life.conglomerate.twitter.archive.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import com.lavish.life.conglomerate.twitter.archive.model.Tweet;
import com.lavish.life.conglomerate.twitter.archive.model.request.TwitterTweetsSearchAPIRequest;
import com.lavish.life.conglomerate.twitter.archive.model.response.TwitterTweetsSearchAPIResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Norbert Powell 
 * @since Created Feb 5, 2019
 *
 */
@Service
@Slf4j
public class TwitterPremiumSearchService {

	private final static String  URL = "https://api.twitter.com/1.1/users/show.json?screen_name=@blessed2breathe";
	private final String twitterAPIBaseURL = "https://api.twitter.com/1.1/";
	private final String searchFullArchive = "tweets/search/fullarchive/prod.json";
	private final String QUERY = "query";
	private final String QUERY_FROM = "from:{}";
	private final String FROM_DATE ="fromDate";
	private final String TO_DATE="toDate";
	private final String NEXT = "next";
	
	@Autowired
	private  OAuth2RestTemplate twitterRestTemplate;
	
	public ResponseEntity<TwitterTweetsSearchAPIResponse> getTweets(TwitterTweetsSearchAPIRequest reqParams){
		log.info("Building Request");
		
		MultiValueMap<String, String> queryParameters = new HttpHeaders();
		queryParameters.add(QUERY, QUERY_FROM.replace("{}", reqParams.getUserName()));
		queryParameters.add(FROM_DATE, String.valueOf(reqParams.getParameters().getFromDate()));
		queryParameters.add(TO_DATE, String.valueOf(reqParams.getParameters().getToDate()));
		if (null != reqParams.getNext())queryParameters.add(NEXT, reqParams.getNext());
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(twitterAPIBaseURL).replaceQueryParams(queryParameters);
		
		HttpEntity<String> entity = new HttpEntity<String>(new HttpHeaders());
		//System.out.println(twitterRestTemplate.exchange(URL, HttpMethod.GET, entity , User.class));
		log.info("Sending Request");
		 
		return paginate(twitterRestTemplate.exchange(builder.path(searchFullArchive).toUriString(), HttpMethod.GET, entity , TwitterTweetsSearchAPIResponse.class));
		
	}
	
	private ResponseEntity<TwitterTweetsSearchAPIResponse>  paginate(ResponseEntity<TwitterTweetsSearchAPIResponse> response){
		//
		if (HttpStatus.TOO_MANY_REQUESTS != response.getStatusCode() && null != response.getBody()) {
			List<Tweet> listOfTweets = new ArrayList<Tweet>();
			TwitterTweetsSearchAPIResponse resp = response.getBody();
			listOfTweets.addAll(resp.getResults());
			String userName = resp.getResults().get(0).getUser().getScreen_name();
			while (resp.getNext() != null) {
				log.debug("Requesting next page with next token: {}", resp.getNext());
				TwitterTweetsSearchAPIRequest req = new TwitterTweetsSearchAPIRequest(userName,resp.getNext(), resp.getRequestParameters()) ;
				resp = getTweets(req).getBody();
				listOfTweets.addAll(resp.getResults());
			}
			response.getBody().getResults().addAll(listOfTweets);
			return response;
		}
		
		return response;
	}

}
