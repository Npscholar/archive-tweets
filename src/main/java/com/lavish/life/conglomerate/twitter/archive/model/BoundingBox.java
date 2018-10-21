package com.lavish.life.conglomerate.twitter.archive.model;

import java.util.List;

import lombok.Data;
/**
 * A bounding box of coordinates which encloses this place. Example:
 * </br>
 * </br>
 * {@code 
{
  "bounding_box": {
    "coordinates": [
      [
        [
          -74.026675,
          40.683935
        ],
        [
          -74.026675,
          40.877483
        ],
        [
          -73.910408,
          40.877483
        ],
        [
          -73.910408,
          40.3935
        ]
      ]
    ],
    "type": "Polygon"
  }
}}
 * * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */

@Data
public class BoundingBox {
	private List<Coordinates> coordinates;
	//The type of data encoded in the coordinates property. This will be “Point” for Tweet coordinates fields. Example:"type": "Point
	private String type;

}
