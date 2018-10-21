package com.lavish.life.conglomerate.twitter.archive.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import lombok.Data;

/**
 * Tweets are the basic atomic building block of all things Twitter.
 * Tweets are also known as “status updates.” 
 * The Tweet object has a long list of ‘root-level’ attributes, including fundamental attributes such as id, created_at, and text.
 *  Tweet objects are also the ‘parent’ object to several child objects. 
 * Tweet child objects include user, entities, and extended_entities. 
 * Tweets that are geo-tagged will have a place child object.
 * {@link https://developer.twitter.com/en/docs/tweets/data-dictionary/overview/tweet-object}
 * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */
@Data
public class Tweet {

	private String created_at;
	private int id;
	private String id_str;
	private String text;
	private String source;
	private boolean truncated;
	private int in_reply_to_status_id;
	private String in_reply_to_status_id_str;
	private int in_reply_to_user_id;
	private String in_reply_to_user_str;
	private String in_reply_to_screen_name;
	private User user;
	private Coordinates coordinates;
	private Places place;
	private int quoted_status_id;
	private String quoted_status_id_str;
	private boolean is_quote_status;
	// TODO is this the best way to handle tweets, retweets, and quoted tweets ?
	private Tweet quoted_status;
	private Tweet retweeted_status;
	private Integer quote_count;
	private int reply_count;
	private int retweet_count;
	private Integer favorite_count;
	private Entities entities;
	private ExtendedEntities entendedEntites;
	private boolean favorited;
	private boolean retweeted;
	private boolean possibly_sensitive;
	private String filter_level;
	private String lang;
	private List <Objects> matching_rules;
	private CurrentUserRetweet current_user_retweet;
	private Map<String, Object> scopes;
	private boolean withheld_copyright;
	private List<String> withheld_in_countries;
	private String withheld_scope;
	@Deprecated
	/*
	 * Nullable. Use the coordinates field instead.
	This deprecated attribute has its coordinates formatted as [lat, long], 
	while all other Tweet geo is formatted as [long, lat].
	*/
	private Object geo;
//	TODO is this the best way to handle extended tweets?
	private ExtendedTweet extendedTweet;
	private List <Integer> display_text_range;
	
	
	
	
}
