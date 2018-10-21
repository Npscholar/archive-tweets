package com.lavish.life.conglomerate.twitter.archive.model;

import java.util.List;

import lombok.Data;
/**
 * The longitude and latitude of the Tweet’s location, as a collection in the form [longitude, latitude]. Example:

"coordinates":[-97.51087576,35.46500176]
 * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */
@Data
public class Coordinates {
	private List<Float> points;

}
