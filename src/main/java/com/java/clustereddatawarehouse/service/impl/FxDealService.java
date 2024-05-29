package com.java.clustereddatawarehouse.service.impl;

import com.java.clustereddatawarehouse.dto.FXDealDto;
import com.java.clustereddatawarehouse.entities.FXDeal;
import com.java.clustereddatawarehouse.exception.RequestAlreadyExistException;
import com.java.clustereddatawarehouse.repository.FXDealRepository;
import com.java.clustereddatawarehouse.service.interfaces.IFXDeal;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class FxDealService implements IFXDeal {

    private final FXDealRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<FXDealDto> create(FXDealDto fxDealDto) {
        log.info("Attempting to create FX deal: {}", fxDealDto);
        if (repository.existsById(fxDealDto.getId())) {
            log.warn("FX deal with ID {} already exists", fxDealDto.getId());
            throw new RequestAlreadyExistException("The Request is already imported");
        }
        FXDeal fxDeal = modelMapper.map(fxDealDto, FXDeal.class);
        fxDeal = repository.save(fxDeal);

        FXDealDto fxDealDto1 = modelMapper.map(fxDeal, FXDealDto.class);
        log.info("FX deal created successfully: {}", fxDealDto1);
        return Optional.ofNullable(fxDealDto1);
    }
}
