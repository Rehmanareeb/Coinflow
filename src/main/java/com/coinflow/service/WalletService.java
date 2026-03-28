package com.coinflow.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.coinflow.entity.Wallet;

import org.springframework.stereotype.Service;

import com.coinflow.repository.WalletRepository;
import com.coinflow.repository.TransactionRepository;
import com.coinflow.entity.Transaction;

import jakarta.transaction.Transactional;

@Service
public class WalletService {
	private final WalletRepository walletRepository;
	private final TransactionRepository transactionRepository;

	public WalletService(WalletRepository walletRepository, TransactionRepository transactionRepository) {
		this.walletRepository = walletRepository;
		this.transactionRepository = transactionRepository;
	}

	public Wallet create(String ownerName, BigDecimal initialBalance) {
		Wallet wallet = new Wallet();
		wallet.setOwnerName(ownerName);
		wallet.setBalance(initialBalance);
		walletRepository.save(wallet);

		return walletRepository.save(wallet);
	}

	public Wallet getWalletById(long id) {
		return walletRepository.findById(id).orElseThrow(() -> new RuntimeException("Wallet not found"));
	}

	@Transactional
	public void transferAmount(Long senderId, Long receiverId, BigDecimal amount) {
		Wallet sender = this.getWalletById(senderId);
		Wallet receiver = this.getWalletById(receiverId);

		if (sender.getBalance().compareTo(amount) < 0) {
			throw new RuntimeException("Insufficient balance");
		}
		sender.setBalance(sender.getBalance().subtract(amount));
		receiver.setBalance(receiver.getBalance().add(amount));
		walletRepository.save(sender);
		walletRepository.save(receiver);

		Transaction receipt = new Transaction();
		receipt.setSenderWalletId(sender.getId());
		receipt.setReceiverWalletId(receiver.getId());
		receipt.setAmount(amount);
		receipt.setTimestamp(LocalDateTime.now());
		transactionRepository.save(receipt);

	}
}