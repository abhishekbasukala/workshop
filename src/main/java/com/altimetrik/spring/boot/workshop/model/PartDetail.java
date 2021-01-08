package com.altimetrik.spring.boot.workshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartDetail {

    private Long partId;
    private String partName;
    private Integer quantity;

}
