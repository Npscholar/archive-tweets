/**
 * 
 */
package com.lavish.life.conglomerate.twitter.archive.model;

import java.util.List;

import lombok.Data;

/**
 * The entities section will contain a user_mentions array containing an object for every user 
 * mention included in the Tweet body, and include an empty array if no user mention is present.
 * 
 * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */
@Data
public class UserMentions {
	private long id;
	private String id_str;
	private List<Integer> indices;
	private String name;
	private String screen_name;

}
