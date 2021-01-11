package com.altimetrik.spring.boot.workshop.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
public class PartResponse extends BaseResponse {

    private String name;
    private String description;
    private Double price_per_unit;

}
