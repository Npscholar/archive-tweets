package com.lavish.life.conglomerate.twitter.archive.model;

import lombok.Data;

/**
 * Perspectival Only surfaces on methods supporting the include_my_retweet parameter, when set to true. Details the Tweet ID of the user’s own retweet (if existent) of this Tweet. Example:

"current_user_retweet": {
  "id": 26815871309,
  "id_str": "26815871309"
}
{@link https://developer.twitter.com/en/docs/tweets/data-dictionary/overview/tweet-object}
 * @author Norbert Powell 
 * @since Created Oct 21, 2018
 *
 */

@Data
public class CurrentUserRetweet {
	private int id;
	private String id_str;

}
