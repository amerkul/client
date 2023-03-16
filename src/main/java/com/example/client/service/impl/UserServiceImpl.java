package com.example.client.service.impl;

import com.example.client.controller.dto.User;
import com.example.client.producer.ReactiveProducerService;
import com.example.client.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final ReactiveProducerService producerService;
    @Override
    public void insertItem(User user) {
        producerService.send(user);
    }

}
