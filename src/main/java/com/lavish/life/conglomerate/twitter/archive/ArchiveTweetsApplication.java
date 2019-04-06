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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableOAuth2Client
@PropertySource("classpath:application.yml")
@EnableWebMvc
public class ArchiveTweetsApplication {
	
	@Value("${accessTokenUri}")
    private String accessTokenUri;

    @Value("${clientID}")
    private String clientID;
 
    @Value("${clientSecret}")
    private String clientSecret;
 
    // type of oauth2 request it is i.e grant_type value amongst other changes 
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
        template.setErrorHandler(new TwitterResponseErrorHandler());
        return template;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(ArchiveTweetsApplication.class, args);
	}
}
