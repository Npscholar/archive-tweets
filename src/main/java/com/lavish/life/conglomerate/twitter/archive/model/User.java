package com.lavish.life.conglomerate.twitter.archive.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * The User object contains public Twitter account metadata and describes the of the Tweet.
 *  Users can be anyone or anything. 
 *  They Tweet, Retweet, add Quotes to Tweets, follow others, create lists, have a home timeline, can be mentioned,
 *   and can be looked up in bulk.
 *   {@link https://developer.twitter.com/en/docs/tweets/data-dictionary/overview/user-object}
 * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */
@Data
public class User {
	private int id;
	private String name;
	private String screen_name;
	private String location;
	private String url;
	private String description;
	private Map<String, Object> derived;
	@JsonProperty("protected")
	private boolean isProtected;
	private boolean verified;
	private int followers_count;
	private int friends_count;
	private int listed_count;
	private int favourites_count;
	private int statuses_count;
	private String created_at;
	private Object utc_offset;
	private Object time_zone;
	private boolean geo_enabled;
	private String lang;
	private boolean contributors_enabled;
	private String profile_background_color;
	private String profile_background_image_url;
	private String profile_background_image_url_https;
	private boolean profile_background_tile;
	private String profile_banner_url;
	private String profile_image_url;
	private String profile_link_color;
	private String profile_sidebar_border_color;
	private String profile_sidebar_fill_color;
	private String profile_text_color;
	private boolean profile_use_background_image;
	private boolean default_profile;
	private boolean default_profile_image;
	private String[] withheld_in_countries;
	private String withheld_scope;
	@Deprecated
	private boolean is_translator;
	@Deprecated
	private boolean following;
	@Deprecated
	private boolean notifications;
}
