/**
 * 
 */
package com.lavish.life.conglomerate.twitter.archive.model.response;

import java.util.List;

import com.lavish.life.conglomerate.twitter.archive.model.Tweet;

import lombok.Data;

/**
 * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */
@Data
public class TwitterTweetsSearchAPIResponse {
	private List<Tweet> results;
	private String next;
	private RequestParameters requestParameters;
	

}
