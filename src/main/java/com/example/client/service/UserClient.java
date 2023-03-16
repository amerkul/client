package com.example.client.service;

import com.example.client.controller.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("users")
public interface UserClient {

    @PostMapping(value = "/users/create")
    User insertItem(@RequestBody User user);

    @GetMapping(value = "/users/all")
    List<User> retrieveAll();

}
