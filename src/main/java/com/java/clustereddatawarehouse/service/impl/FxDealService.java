package com.java.clustereddatawarehouse.service.impl;

import com.java.clustereddatawarehouse.dto.FXDealDto;
import com.java.clustereddatawarehouse.entities.FXDeal;
import com.java.clustereddatawarehouse.exception.RequestAlreadyExistException;
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

        if(repository.existsById(fxDealDto.getId()))
            throw new RequestAlreadyExistException(" The Request is already imported");
        FXDeal fxDeal = modelMapper.map(fxDealDto,FXDeal.class);
        fxDeal = repository.save(fxDeal);
        return Optional.ofNullable(fxDeal);
    }
}
