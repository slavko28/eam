package com.demo.service.amazonSNS;

public interface MessageService {

    String publishMessage(String message, String topicArn);

}
