package com.coinflow.dto;

import lombok.Data;
import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Data
public class TransferRequest {
    @NotNull
    private Long senderId;
    private Long receiverId;

    @NotNull
    @Positive
    private BigDecimal amount;
}
