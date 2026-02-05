package com.coinflow.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class WalletRequest {

    private String ownerName;
    private BigDecimal initialBalance;
}
