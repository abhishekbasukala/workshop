package com.altimetrik.spring.boot.workshop.service;

import com.altimetrik.spring.boot.workshop.client.PartClient;
import com.altimetrik.spring.boot.workshop.model.EstimateRequest;
import com.altimetrik.spring.boot.workshop.model.EstimateResponse;
import com.altimetrik.spring.boot.workshop.model.EstimateType;
import com.altimetrik.spring.boot.workshop.model.PartResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class WorkshopService {

    @Autowired
    private PartClient partClient;

    private void initializeLaborChargeMap(Map<String, Double> laborChargeMap) {
        laborChargeMap.put(EstimateType.BRAKE.getType(), 100.00);
        laborChargeMap.put(EstimateType.TIRE.getType(), 80.00);
    }

    public EstimateResponse getWorkshopEstimate(EstimateRequest estimateRequest){
        Map<String, Double> laborChargeMap = new HashMap<>();
        initializeLaborChargeMap(laborChargeMap);

        AtomicReference<Double> totalCostEstimate = new AtomicReference<>(0.0);
        estimateRequest.getPartDetails().forEach(partDetail -> {
            PartResponse partResponseResponse = partClient.fetchPartDetails(partDetail.getPartId()).getBody();
            totalCostEstimate.updateAndGet(value -> new Double((double) (value + partResponseResponse.getPrice_per_unit() * partDetail.getQuantity())));
        });
        totalCostEstimate.updateAndGet(value -> new Double((double) (value + laborChargeMap.get(estimateRequest.getEstimateType()))));

        return EstimateResponse.builder().totalCostEstimate(totalCostEstimate.get()).build();
    }
}
