package com.lavish.life.conglomerate.twitter.archive;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableOAuth2Client
@PropertySource("classpath:application.yml")
public class ArchiveTweetsApplication {
	
	@Value("${accessTokenUri}")
    private String accessTokenUri;
 
//    @Value("${userAuthorizationUri}")
//    private String userAuthorizationUri;
 
    @Value("${clientID}")
    private String clientID;
 
    @Value("${clientSecret}")
    private String clientSecret;
 
    @Bean
    public OAuth2ProtectedResourceDetails twitter() {
    	ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setId("twitter");
        details.setClientId(clientID);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        details.setTokenName("oauth_token");
        return details;
    }
 
    @Bean
    public OAuth2RestTemplate twitterRestTemplate(OAuth2ClientContext clientContext) {
        OAuth2RestTemplate template = new OAuth2RestTemplate(twitter(), clientContext);
        template.setAccessTokenProvider(new ClientCredentialsAccessTokenProvider());
        return template;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(ArchiveTweetsApplication.class, args);
	}
}
