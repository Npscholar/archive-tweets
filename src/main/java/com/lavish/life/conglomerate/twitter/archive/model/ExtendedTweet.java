package com.lavish.life.conglomerate.twitter.archive.model;

import java.util.List;

import lombok.Data;

@Data
public class ExtendedTweet {
	private String full_text;
	private List <Integer> display_text_range;
	private Entities entites;
	

}
