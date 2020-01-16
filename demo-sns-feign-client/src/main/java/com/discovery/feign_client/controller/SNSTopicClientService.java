package com.discovery.feign_client.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("demo-amazon-service")
public interface SNSTopicClientService {

    @RequestMapping(value = "/topics")
    List<String> getTopicList();

    @RequestMapping(value = "/create/topic")
    String createNewTopic(String name);

    @RequestMapping(value = "/delete/topic")
    String removeTopic(String topicArm);

}