package com.java.clustereddatawarehouse.service.impl;

import com.java.clustereddatawarehouse.dto.FXDealDto;
import com.java.clustereddatawarehouse.entities.FXDeal;
import com.java.clustereddatawarehouse.repository.FXDealRepository;
import com.java.clustereddatawarehouse.service.interfaces.IFXDeal;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class FxDealService implements IFXDeal {

    private final FXDealRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<FXDeal> create(FXDealDto fxDealDto) {

        return null;
    }
}
