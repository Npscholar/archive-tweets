/**
 * 
 */
package com.lavish.life.conglomerate.twitter.archive;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Norbert Powell 
 * @since Created Feb 5, 2019
 *
 */
@Slf4j
public class TwitterResponseErrorHandler extends DefaultResponseErrorHandler {

	/* (non-Javadoc)
	 * @see org.springframework.web.client.ResponseErrorHandler#handleError(org.springframework.http.client.ClientHttpResponse)
	 */
	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		if( HttpStatus.TOO_MANY_REQUESTS.equals(response.getStatusCode())) {
			log.error("{}, {}", response.getRawStatusCode(), response.getStatusText());
			// DO nothing and let it propogate to client 
			// TODO:
			// notify listeners 
			// save status and update schedule to start on the next day time timestamp which is return in the first successful response 
		}else {
			super.handleError(response);
		}
		
	}

}
