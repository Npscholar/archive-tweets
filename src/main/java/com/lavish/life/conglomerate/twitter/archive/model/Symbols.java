/**
 * 
 */
package com.lavish.life.conglomerate.twitter.archive.model;

import java.util.List;

import lombok.Data;

/**
 * The entities section will contain a symbols array containing an object for every
 *  $cashtag included in the Tweet body, and include an empty array if no symbol is present.
 * 
 * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */
@Data
public class Symbols {

	private List<Integer> indicies;
	private String text;
}
