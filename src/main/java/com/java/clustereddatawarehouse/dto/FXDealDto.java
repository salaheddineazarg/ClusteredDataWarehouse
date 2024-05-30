package com.java.clustereddatawarehouse.dto;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FXDealDto {


    @NotBlank(message = "Deal id must not be blank")
    private String id;

    @NotBlank(message = "Ordering currency iso code must not be blank")
    private String orderingCurrencyIsoCode;

    @NotBlank(message = "To currency iso code must not be blank")
    private String toCurrencyIsoCode;

    @CreationTimestamp
    private LocalDateTime dealTimestamp;

    @NotNull(message = "Deal amount must not be null")
    @Positive(message = "deal amount should be a positive value.")
    private Double dealAmount;
}
