package com.java.clustereddatawarehouse;

import com.java.clustereddatawarehouse.dto.FXDealDto;
import com.java.clustereddatawarehouse.entities.FXDeal;
import com.java.clustereddatawarehouse.exception.RequestAlreadyExistException;
import com.java.clustereddatawarehouse.repository.FXDealRepository;
import com.java.clustereddatawarehouse.service.impl.FxDealService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FXDealServiceTest {

    @Mock
    private FXDealRepository fxDealRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private FxDealService fxDealService;



    @Test
    public void testCreateWhenIdAlreadyExists() {
        FXDealDto fxDealDto = FXDealDto.builder()
                .id("test")
                .orderingCurrencyIsoCode("USA")
                .toCurrencyIsoCode("AED")
                .dealAmount(150.50)
                .build();

        when(fxDealRepository.existsById(fxDealDto.getId())).thenReturn(true);
        assertThatExceptionOfType(RequestAlreadyExistException.class)
                .isThrownBy(() -> fxDealService.create(fxDealDto))
                .withMessage("The Request is already imported");
    }

    @Test
    public void testCreateMethodSuccess() {
        FXDeal fxDeal = FXDeal.builder()
                .id("test1")
                .orderingCurrencyIsoCode("USA")
                .toCurrencyIsoCode("AED")
                .dealAmount(120.50)
                .build();

        FXDealDto fxDealDto = FXDealDto.builder()
                .id("test2")
                .orderingCurrencyIsoCode("USA")
                .toCurrencyIsoCode("AED")
                .dealAmount(150.50)
                .build();

        given(modelMapper.map(fxDealDto, FXDeal.class)).willReturn(fxDeal);
        given(fxDealRepository.existsById(fxDealDto.getId())).willReturn(false);
        given(fxDealRepository.save(fxDeal)).willReturn(fxDeal);
        given(modelMapper.map(fxDeal, FXDealDto.class)).willReturn(fxDealDto);
        Optional<FXDealDto> result = fxDealService.create(fxDealDto);
        assertThat(result.get()).isEqualTo(fxDealDto);
        verify(fxDealRepository, times(1)).existsById(fxDealDto.getId());
        verify(fxDealRepository, times(1)).save(fxDeal);
    }
}
