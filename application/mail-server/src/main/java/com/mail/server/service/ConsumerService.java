package com.mail.server.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumerService {
    @KafkaListener(topics = "message-topic")
    public void consume(String message) throws IOException {
        System.out.println("주문자 :" + message);
    }
}
