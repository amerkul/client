package com.example.client.controller;

import com.example.client.controller.dto.CatalogDto;
import com.example.client.controller.dto.User;
import com.example.client.service.CloudService;
import com.example.client.service.UserClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final CloudService service;
    private final UserClient client;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/create")
    public CatalogDto create(@RequestBody CatalogDto dto) {
        service.insertItem(dto);
        return dto;
    }

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CatalogDto> getAll() {
        log.debug("Start get all items from catalog method");
        return service.retrieveAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user")
    public User createUser(@RequestBody User user) {
        return client.insertItem(user);
    }

    @GetMapping(value = "/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        System.out.println("Get all users");
        return client.retrieveAll();
    }

}
