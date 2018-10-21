/**
 * 
 */
package com.lavish.life.conglomerate.twitter.archive.model;

import java.util.List;

import lombok.Data;

/**
 * The entities section will contain a polls array containing a single poll object if the Tweet contains a poll. 
 *  If no poll is included, there will be no polls array in the entities section.
 *  </br>
 *  </br>
 *  Note that these Poll metadata are only available with the following Enterprise APIs:

Volume streams (Decahose )
Real-time PowerTrack
Historical PowerTrack
Twitter Search APIs (Full-Archive Search and 30-Day Search)
 * 
 * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */
@Data
public class Poll {
	private List<Option> options;
	private String end_datetime;
	private String duration_minutes;
	
	
}
