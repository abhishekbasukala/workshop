package com.altimetrik.spring.boot.workshop.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartResponse {

    private String name;
    private String description;
    private Double price_per_unit;

}
