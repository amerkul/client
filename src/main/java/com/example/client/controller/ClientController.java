package com.example.client.controller;

import com.example.client.controller.dto.CatalogDto;
import com.example.client.service.CloudService;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public CatalogDto create(@RequestBody CatalogDto dto) {
        service.insertItem(dto);
        return dto;
    }

    @GetMapping(value = "/all", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CatalogDto> getAll() {
        log.debug("Start get all items from catalog method");
        return service.retrieveAll();
    }

}
