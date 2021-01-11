package com.altimetrik.spring.boot.workshop.client;

import com.altimetrik.spring.boot.workshop.configuration.CommonFeignConfiguration;
import com.altimetrik.spring.boot.workshop.model.PartResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "part-client", url = "${part_endpoint}", configuration = {CommonFeignConfiguration.class})
public interface PartClient {

    @GetMapping(value = "/api/part/directory/{id}", produces = "application/json")
    ResponseEntity<PartResponse> fetchPartDetails(@PathVariable(value = "id") Long id);

}
