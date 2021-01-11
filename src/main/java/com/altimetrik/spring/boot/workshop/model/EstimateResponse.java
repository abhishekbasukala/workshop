package com.altimetrik.spring.boot.workshop.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
public class EstimateResponse extends BaseResponse{

    private Double totalCostEstimate;

}
