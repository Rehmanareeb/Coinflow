package com.coinflow.service;

import java.math.BigDecimal;


import com.coinflow.entity.Wallet;

import org.springframework.stereotype.Service;


import com.coinflow.repository.WalletRepository;

import jakarta.transaction.Transactional;

@Service
public class WalletService {
	private final WalletRepository walletRepository;

	public WalletService(WalletRepository walletRepository) {
		this.walletRepository = walletRepository;
	}

	public Wallet create(String ownerName, BigDecimal initialBalance) {
		Wallet wallet = new Wallet();
		wallet.setOwnerName(ownerName);
		wallet.setBalance(initialBalance);
		walletRepository.save(wallet);

       return walletRepository.save(wallet);
	}
	public Wallet getWalletById(long id){
		return walletRepository.findById(id).orElseThrow(()->new RuntimeException("Wallet not found"));
	}


	@Transactional
	public void TransferAmount(Long SenderId,Long ReceiverId,BigDecimal amount){
		Wallet sender = this.getWalletById(SenderId);
		Wallet receiver = this.getWalletById(ReceiverId);


		if (sender.getBalance().compareTo(amount) < 0) {
			throw new RuntimeException("Insufficient balance");
		}
		sender.setBalance(sender.getBalance().subtract(amount));
		receiver.setBalance(receiver.getBalance().add(amount));
		walletRepository.save(sender);
		walletRepository.save(receiver);
	}
}