/**
 * 
 */
package com.lavish.life.conglomerate.twitter.archive.model;

import java.util.List;

import lombok.Data;

/**
 * The entities section will contain a media array containing a single media object if any media 
 * object has been ‘attached’ to the Tweet. If no native media has been attached, 
 * there will be no media array in the entities. For the following reasons the extended_entities
 *  section should be used to process Tweet native media:
+ Media type will always indicate ‘photo’ even in cases of a video and GIF being attached to Tweet.
+ Even though up to four photos can be attached, only the first one will be listed in the entities section.

 * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */
@Data
public class Media {
	private String display_url;
	private String expanded_url;
	private int id;
	private String id_str;
	private List<Integer> indicies;
	private String media_url;
	private String media_url_https;
	private Sizes sizes;
	private Integer source_status_id;
	private Integer source_status_id_str;
	private String type;
	private String url;
	
	
	

}
