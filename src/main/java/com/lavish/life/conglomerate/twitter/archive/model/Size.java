/**
 * 
 */
package com.lavish.life.conglomerate.twitter.archive.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */
@Data
public class Size {
	@JsonProperty("w")
	private int width;
	@JsonProperty("height")
	private int h;
	private String resize;

}
