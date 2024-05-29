package com.java.clustereddatawarehouse.controller;


import com.java.clustereddatawarehouse.dto.FXDealDto;
import com.java.clustereddatawarehouse.service.interfaces.IFXDeal;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/fx-deal")
public class FXDealController {

    private final IFXDeal service;

    @PostMapping
    public ResponseEntity<FXDealDto> create(@Valid @RequestBody FXDealDto fxDealDto){

        log.info("Received request to create FX deal: {}", fxDealDto);
        return service.create(fxDealDto)
                .map(fxDeal -> {
                    log.info("FX deal created successfully: {}", fxDeal);
                    return new ResponseEntity<>(fxDeal, HttpStatus.CREATED);
                })
                .orElseGet(() -> {
                    log.warn("FX deal creation failed");
                    return new ResponseEntity<>(null, HttpStatus.OK);
                });
    }
}
