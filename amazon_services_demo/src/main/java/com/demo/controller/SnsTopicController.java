package com.demo.controller;

import com.demo.service.amazonSNS.TopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class SnsTopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping(value = "/topics")
    public List<String> getTopicList() {
        log.debug("Receive request to get all topics");
        return topicService.getTopicList();
    }

    @PostMapping(value = "/create/topic")
    public String createNewTopic(@RequestParam String topicName) {
        log.debug("Receive request to create new topic with name: {}", topicName);
        return topicService.createNewTopic(topicName);
    }

    @DeleteMapping(value = "/delete/topic")
    public void deleteTopic(@RequestParam String topicArn) {
        log.debug("Receive request to delete topic with name: {}", topicArn);
        topicService.removeTopic(topicArn);
    }

}
