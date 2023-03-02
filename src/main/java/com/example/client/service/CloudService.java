package com.example.client.service;

import com.example.client.controller.dto.CatalogDto;

import java.util.List;

public interface CloudService {

    void insertItem(CatalogDto catalog);
    List<CatalogDto> retrieveAll();

}
