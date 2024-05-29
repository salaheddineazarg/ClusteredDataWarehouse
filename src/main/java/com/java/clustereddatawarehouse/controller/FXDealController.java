package com.java.clustereddatawarehouse.controller;


import com.java.clustereddatawarehouse.dto.FXDealDto;
import com.java.clustereddatawarehouse.service.interfaces.IFXDeal;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/fx-deal")
public class FXDealController {

    private final IFXDeal service;


    @PostMapping
    public ResponseEntity<FXDealDto> create(@Valid @RequestBody FXDealDto fxDealDto){

        return service.create(fxDealDto)
                .map(fxDeal -> new ResponseEntity(fxDeal, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }
}
