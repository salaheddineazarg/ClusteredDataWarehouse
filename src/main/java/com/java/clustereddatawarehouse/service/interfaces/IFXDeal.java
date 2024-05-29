package com.java.clustereddatawarehouse.service.interfaces;


import com.java.clustereddatawarehouse.dto.FXDealDto;
import com.java.clustereddatawarehouse.entities.FXDeal;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IFXDeal {

    Optional<FXDealDto> create(FXDealDto fxDealDto);
}
