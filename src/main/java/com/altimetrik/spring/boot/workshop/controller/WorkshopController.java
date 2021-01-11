package com.altimetrik.spring.boot.workshop.controller;

import com.altimetrik.spring.boot.workshop.model.EstimateRequest;
import com.altimetrik.spring.boot.workshop.model.EstimateResponse;
import com.altimetrik.spring.boot.workshop.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cost")
public class WorkshopController {

    @Autowired
    private WorkshopService workshopService;

    @PostMapping("/estimate")
    public ResponseEntity<EstimateResponse> getEstimate(@RequestBody EstimateRequest estimateRequest){
        EstimateResponse response = workshopService.getWorkshopEstimate(estimateRequest);
        return ResponseEntity.ok(response);
    }
}
