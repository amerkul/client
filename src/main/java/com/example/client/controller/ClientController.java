package com.example.client.controller;

import com.example.client.controller.dto.CatalogDto;
import com.example.client.controller.dto.User;
import com.example.client.service.CloudService;
import com.example.client.service.UserService;
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

    private final CloudService cloudService;
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/create")
    public CatalogDto create(@RequestBody CatalogDto dto) {
        cloudService.insertItem(dto);
        return dto;
    }

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CatalogDto> getAll() {
        log.debug("Start get all items from catalog method");
        return cloudService.retrieveAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user")
    public void createUser(@RequestBody User user) {
        userService.insertItem(user);
    }

}
