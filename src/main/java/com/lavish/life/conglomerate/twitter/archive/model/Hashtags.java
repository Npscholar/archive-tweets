package com.lavish.life.conglomerate.twitter.archive.model;

import java.util.List;

import lombok.Data;

/**
 * The entities section will contain a hashtags array containing an object for every hashtag
 *  included in the Tweet body, and include an empty array if no hashtags are present.
 * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */
@Data
public class Hashtags {
	private List<Integer> indices;
	private String text;

}
