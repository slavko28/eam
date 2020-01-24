package com.demo.service.amazonSNS;

import com.demo.model.Message;

public interface MessageService {

    String publishMessage(String message, String topicArn);

}
