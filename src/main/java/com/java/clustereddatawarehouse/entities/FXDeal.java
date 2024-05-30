package com.java.clustereddatawarehouse.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class FXDeal {

    @Id
    public String id;


    @NotBlank(message = "Ordering currency iso code must not be blank")
    @Column(nullable = false)
    private String orderingCurrencyIsoCode;


    @NotBlank(message = "To currency iso code must not be blank")
    @Column(nullable = false)
    private String toCurrencyIsoCode;

    @CreationTimestamp
    private LocalDateTime dealTimestamp;

    @Positive(message = "deal amount should be a positive value.")
    @NotNull(message = "Deal amount must not be null")
    @Column(nullable = false)
    private Double dealAmount;
}
