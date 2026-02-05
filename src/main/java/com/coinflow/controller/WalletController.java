package com.coinflow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coinflow.dto.TransferRequest;
import com.coinflow.dto.WalletRequest;
import com.coinflow.entity.Wallet;
import com.coinflow.service.WalletService;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public Wallet CreateWallet(@RequestBody WalletRequest walletRequest) {
        return walletService.create(walletRequest.getOwnerName(), walletRequest.getInitialBalance());
    }

    @GetMapping("/{id}")
    public Wallet getWalletInfo(@PathVariable long id) {
        return walletService.getWalletById(id);
    }

    @PostMapping("/transfer")
    public String transferMoney(@RequestBody TransferRequest request) {
        walletService.TransferAmount(
                request.getSenderId(),
                request.getReceiverId(),
                request.getAmount());
        return "Transfer Successful!";
    }
}
