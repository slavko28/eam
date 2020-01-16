package com.demo.controller;

import com.demo.service.amazonSNS.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SnsMessageController {

    @Autowired
    private MessageService messageService;

    @PutMapping(value = "/publish")
    public String publishMessage(@RequestParam String message, @RequestParam String topicArn) {
        log.debug("\nReceive request to publish new message:\n {}\n into the topic: {}", message, topicArn);
        return messageService.publishMessage(message, topicArn);
    }
}
