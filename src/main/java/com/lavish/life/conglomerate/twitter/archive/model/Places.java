package com.lavish.life.conglomerate.twitter.archive.model;

import lombok.Data;

/**
 * Tweets can be associated with a location, generating a Tweet that has been ‘geo-tagged.’ 
 * Tweet locations can be assigned by using the Twitter user-interface or when posting a Tweet using the API.
 *  Tweet locations can be an exact ‘point’ location, or a Twitter Place with a ‘bounding box’ that
 *   describes a larger area ranging from a venue to an entire region.
</br>
</br>
There are two ‘root-level’ JSON objects used to describe the location associated with a Tweet: coordinates and place.
</br>
</br>
{@code {
   "coordinates": {}, 
   "place": {}
}}
</br>
</br>
The place object is always present when a Tweet is geo-tagged,
 while the coordinates object is only present (non-null) when the Tweet is assigned an exact location.
  If an exact location is provided, the coordinates object will provide a [long, lat] array with the geographical coordinates,
   and a Twitter Place that corresponds to that location will be assigned.
   {@linkhttps://developer.twitter.com/en/docs/tweets/data-dictionary/overview/geo-objects}
 * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */
@Data
public class Places {
	private String id;
	private String url;
	private String place_type;
	private String name;
	private String full_name;
	private String country_code;
	private String country;
	private BoundingBox bounding_box;
	private String attributes;
}
