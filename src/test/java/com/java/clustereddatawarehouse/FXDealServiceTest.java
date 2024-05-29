package com.java.clustereddatawarehouse;


import com.java.clustereddatawarehouse.dto.FXDealDto;
import com.java.clustereddatawarehouse.entities.FXDeal;
import com.java.clustereddatawarehouse.exception.RequestAlreadyExistException;
import com.java.clustereddatawarehouse.repository.FXDealRepository;
import com.java.clustereddatawarehouse.service.impl.FxDealService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FXDealServiceTest {


    @Mock
    private FXDealRepository repository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private FxDealService fxDealService;

    private FXDealDto fxDealDto;
    private FXDeal fxDeal;

    @BeforeEach
    public void setUp() {

        fxDealDto = new FXDealDto();
        fxDealDto.setId("test");
        fxDealDto.setToCurrencyIsoCode("USD");
        fxDealDto.setOrderingCurrencyIsoCode("AED");

        fxDeal = new FXDeal();
        fxDeal.setId("test");
        fxDeal.setToCurrencyIsoCode("USD");
        fxDeal.setOrderingCurrencyIsoCode("AED");


    }

    @Test
    public void create_FXDealAlreadyExists_ThrowsException() {
        when(repository.existsById(fxDealDto.getId())).thenReturn(true);

        RequestAlreadyExistException exception = assertThrows(RequestAlreadyExistException.class, () -> {
            fxDealService.create(fxDealDto);
        });
        assertEquals("The Request is already imported", exception.getMessage());
        verify(repository, never()).save(any(FXDeal.class));
    }

    @Test
    public void create_NewFXDeal_Success() {
        when(repository.existsById(fxDealDto.getId())).thenReturn(false);
        when(modelMapper.map(fxDealDto, FXDeal.class)).thenReturn(fxDeal);
        when(repository.save(fxDeal)).thenReturn(fxDeal);
        when(modelMapper.map(fxDeal, FXDealDto.class)).thenReturn(fxDealDto);
        Optional<FXDealDto> result = fxDealService.create(fxDealDto);
        assertTrue(result.isPresent());
        assertEquals(fxDealDto, result.get());
        verify(repository, times(1)).save(fxDeal);
    }
}
