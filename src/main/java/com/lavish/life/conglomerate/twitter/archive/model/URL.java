/**
 * 
 */
package com.lavish.life.conglomerate.twitter.archive.model;

import java.util.List;

import lombok.Data;

/**
 * The entities section will contain a urls array containing an object for every
 *  link included in the Tweet body, and include an empty array if no links are present.
 * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */
@Data
public class URL {
	private String display_url;
	private String expanded_url;
	private List<Integer> indices;
	private String url;
	private int status;
	private String title;
	private String description;
	

}
