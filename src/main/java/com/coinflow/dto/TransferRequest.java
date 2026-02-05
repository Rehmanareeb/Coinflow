package com.coinflow.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TransferRequest {
    private Long senderId, receiverId;
    private BigDecimal amount;
}
