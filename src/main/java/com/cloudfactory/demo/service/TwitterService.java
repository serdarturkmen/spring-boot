package com.cloudfactory.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TwitterService {

    @Autowired
    private Twitter twitter;

    public String updateStatus() throws TwitterException {

       // Twitter twitter = twitterFactory.getInstance();
        Status status = twitter.updateStatus("hello");
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
        return status.getText();

    }

    public List<String> getLatestTweets() {
        List<String> tweets = new ArrayList<>();
        try {
            //Twitter twitter = twitterFactory.getSingleton();
            ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
            for (Status status : homeTimeline) {
                tweets.add(status.getText());
            }
        } catch (TwitterException e) {
            throw new RuntimeException(e);
        }
        return tweets;

    }

}
