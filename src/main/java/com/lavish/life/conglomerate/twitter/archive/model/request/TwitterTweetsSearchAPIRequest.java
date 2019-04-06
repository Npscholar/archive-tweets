/**
 * 
 */
package com.lavish.life.conglomerate.twitter.archive.model.request;

import com.lavish.life.conglomerate.twitter.archive.model.response.RequestParameters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Norbert Powell 
 * @since Created Feb 5, 2019
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TwitterTweetsSearchAPIRequest {
	private String userName;
	private String next;
	private RequestParameters parameters;
	
}
