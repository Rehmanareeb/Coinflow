package com.coinflow.dto;

import lombok.Data;
import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.PositiveOrZero;

@Data
public class WalletRequest {

    @NotNull
    private Long userId;

    @NotNull
    @PositiveOrZero
    private BigDecimal initialBalance;
}