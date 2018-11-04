package com.cloudfactory.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TwitterConfiguration {

    @Value("${twitter4j.oauth.consumer-key}")
    private String consumerKey;


    public TwitterConfiguration() {
    }

    @Bean
    public Twitter twitter() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey(consumerKey)
            .setOAuthConsumerSecret("yourConsumerSecret")
            .setOAuthAccessToken("yourAccessToken")
            .setOAuthAccessTokenSecret("yourTokenSecret");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        return twitter;

    }


}
