package com.example.client.producer;

import com.example.client.controller.dto.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReactiveProducerService {

    private final ReactiveKafkaProducerTemplate<String, User> reactiveKafkaProducerTemplate;

    @Value("${spring.kafka.topic}")
    private String topic;

    public ReactiveProducerService(ReactiveKafkaProducerTemplate<String, User> reactiveKafkaProducerTemplate) {
        this.reactiveKafkaProducerTemplate = reactiveKafkaProducerTemplate;
    }

    public void send(User user) {
        reactiveKafkaProducerTemplate.send(topic, user).subscribe();
    }

}
