/**
 * 
 */
package com.lavish.life.conglomerate.twitter.archive.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lavish.life.conglomerate.twitter.archive.model.Tweet;

/**
 * @author Norbert Powell 
 * @since Created Feb 5, 2019
 *
 */
public interface MongoRepo extends MongoRepository<Tweet,String>	{
	

}
