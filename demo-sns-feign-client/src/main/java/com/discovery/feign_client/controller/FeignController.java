package com.discovery.feign_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeignController {

    @Autowired
    private SNSTopicClientService snsTopicClientService;

    @GetMapping(value = "/client/topics")
    public List<String> getTopicList() {
        return snsTopicClientService.getTopicList();
    }

    @PostMapping(value = "/client/create/topic")
    public String createNewTopic(@RequestParam String topicName) {
        return snsTopicClientService.createNewTopic(topicName);
    }

    @DeleteMapping(value = "/client/delete/topic")
    public void deleteTopic(@RequestParam String topicArn) {
        snsTopicClientService.removeTopic(topicArn);
    }

}
