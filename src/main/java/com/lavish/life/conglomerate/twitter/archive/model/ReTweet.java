//package com.lavish.life.conglomerate.twitter.archive.model;
//
///**
// * From the Twitter API perspective, Retweet and Quote Tweets are special kinds of Tweets that contain the original Tweet as an embedded object. So Retweets and Quote Tweet objects are parents of a child 'original' Tweet (and thus double the size). Retweets have a top-level "retweeted_status" object, and Quoted Tweets have a "quoted_status" object. For consistency, these top-level Retweet and Quote Tweet objects also have a text property and associated entities. However, the entities at the top level can differ from the entities provided by the embedded 'original' entities. In case of Retweets, new text is prepended to the original Tweet body. For Quoted Tweets, new text is appended to the Tweet body.
//
//In general, the best practice is to retrieve the text, entities, original author and date from the original Tweet in retweeted_status whenever this exists. An exception is getting Twitter entities that are part of the additive Quote. (example?) See below for more details and tips.
//
//Retweets
//An important detail with Retweets is that no additional Twitter entities can be added to the Tweet. Users can not add hashtags, URLs or other details when they Retweet. However, the Retweet (top-level) text attribute is composed of the original Tweet text with “RT @username: ” prepended.  
//
//In some cases, especially with accounts with long user names, the combination of these new characters and the original Tweet body can easily exceed the original Tweet text length limit of 140 characters. In order to preserve support for 140 character based display and storage, the top-level body truncates the end of the Tweet body and adds an ellipsis (“…”). Consequently, some top-level entities positioned at the end of the original Tweet might be incorrect or missing, for instance in the case of a truncated hashtag or URL entry.
//
//[Example here? Just refer to Tweet IDs linking to examples] https://twitter.com/FloodSocial/status/907974220298125312
//
//Just another test Tweet that needs to be exactly 140 characters with trailing URL and hashtag DropletDropletDropletDropletDropletDropletDropletDropletDropletDropletDropletDropletDroplet http://wapo.st/2w8iwPQ  #Testing
//In the above example, both the URL and hashtag were affected. Since the hashtag was completely truncated and the URL partially truncated, these are missing from the the top-level entities. You will also notice the additional user_mentions top-level entity coming from the “RT @floodsocial: ” prefix on the text field.
//
//However, the Tweet text and entities in retweeted_status perfectly reflect the original Tweet with no truncation or incorrect entities, hence our recommendation to rely on the nested retweeted_status object for Retweets.
//
// * @author Norbert Powell 
// * @since Created Oct 21, 2018
// *
// */
//@Data
//public class ReTweet {
//	private 
//
//}
