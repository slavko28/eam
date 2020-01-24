package com.discovery.feign_client.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {

    private String message;
    private String topicArn;


}
