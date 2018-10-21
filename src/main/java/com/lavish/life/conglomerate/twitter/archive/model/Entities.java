package com.lavish.life.conglomerate.twitter.archive.model;

import java.util.List;

import lombok.Data;

/**
A collection of common entities found in Tweets, including hashtags, links, and user mentions. 
This entities object does include a media attribute, but its implementation in the entiites section is only completely
 accurate for Tweets with a single photo. For all Tweets with more than one photo, a video, or animated GIF,
  the reader is directed to the extended_entities section.
{@link https://developer.twitter.com/en/docs/tweets/data-dictionary/overview/entities-object}
 * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */

@Data
public class Entities {
	private List<Hashtags> hashtags;
	private List<Media> media;
	private List<URL> urls;
	private List<UserMentions> user_mentions;
	private List<Symbols> symbols;
	private List<Poll> polls;

}
