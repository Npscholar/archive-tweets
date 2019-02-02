/**
 * 
 */
package com.lavish.life.conglomerate.twitter.archive.model.response;

import java.util.Date;

import lombok.Data;

/**
 * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */
@Data
public class RequestParameters {
		private Integer maxResults;
		private Date fromDate;
		private Date toDate;

}
