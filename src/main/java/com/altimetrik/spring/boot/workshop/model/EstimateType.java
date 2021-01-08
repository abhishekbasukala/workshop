package com.altimetrik.spring.boot.workshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstimateType {

    BRAKE("BRAKE"),
    TIRE("TIRE");

    private String type;
}
