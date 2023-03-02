package com.example.client.controller.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogDto {

    private Long id;
    private String name;
    private String category;
    private String color;
    private Integer price;

}
