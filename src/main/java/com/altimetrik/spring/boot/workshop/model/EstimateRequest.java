package com.altimetrik.spring.boot.workshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstimateRequest {

    private String estimateType;
    private List<PartDetail> partDetails;

}
