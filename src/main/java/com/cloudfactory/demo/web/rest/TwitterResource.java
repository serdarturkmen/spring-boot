package com.cloudfactory.demo.web.rest;

import com.cloudfactory.demo.service.TwitterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

import java.util.List;

@RestController
@RequestMapping("/api/twitter")
public class TwitterResource {

    private final TwitterService twitterService;

    public TwitterResource(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @GetMapping()
    public String hello() {
        return "hello";
    }

    @GetMapping("/update-status")
    public String updateStatus() throws TwitterException {
        return twitterService.updateStatus();
    }

    @GetMapping("/latest-tweets")
    public List<String> latestTweets() {
        return twitterService.getLatestTweets();
    }

}
