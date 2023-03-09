package com.example.client.service;

import com.example.client.controller.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("users")
public interface UserClient {

    @RequestMapping(method = RequestMethod.POST, value = "/users/create")
    User insertItem(@RequestBody User user);

    @RequestMapping(method = RequestMethod.GET, value = "/users/all")
    List<User> retrieveAll();

}
