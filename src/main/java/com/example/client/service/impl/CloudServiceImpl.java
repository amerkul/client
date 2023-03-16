package com.example.client.service.impl;

import com.example.client.controller.dto.CatalogDto;
import com.example.client.service.CloudService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CloudServiceImpl implements CloudService {

    private static final String BASE_URL = "http://cloud:8080/catalog";
    private static final String CLOUD_SERVICE_INSERT = "cloudServiceInsert";
    public static final String USER_SERVICE="userService";
    private final RestTemplate restTemplate;

    @Override
    @CircuitBreaker(name = CLOUD_SERVICE_INSERT, fallbackMethod = "logExceptionMessage")
    public void insertItem(CatalogDto catalog) {
        restTemplate.postForObject(BASE_URL + "/create", catalog, CatalogDto.class);
    }

    private void logExceptionMessage(CatalogDto catalog, Exception ex) {
        log.debug(ex.getMessage());
    }


    @CircuitBreaker(name =USER_SERVICE,fallbackMethod = "getAllAvailableProducts")
    public List<CatalogDto> retrieveAll() {
        return restTemplate.getForObject(BASE_URL + "/all", ArrayList.class);
    }


    public List<CatalogDto> getAllAvailableProducts(Exception e){
        log.debug("Exception: " + e.getMessage());
        return new ArrayList<>();
    }

}
