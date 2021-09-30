package com.factorit.crypto.crypto.service.transaction;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factorit.crypto.crypto.dto.TransactionDTO;
import com.factorit.crypto.crypto.model.Transaction;
import com.factorit.crypto.crypto.model.User;
import com.factorit.crypto.crypto.repository.TransactionRepository;
import com.factorit.crypto.crypto.service.user.UserService_impl;

@Service
public class TransactionService_impl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private UserService_impl userService;
	
	//Guarda una nueva transaccion en bd y se la asigna al usuario correspondiente para luego actualizarlo en bd.
	@Transactional
	@Override
	public Transaction newUserTransaction(TransactionDTO transactionDTO) {
		Transaction newTransaction = new Transaction();
		newTransaction.setAsset(transactionDTO.getAsset());
		newTransaction.setCommission(transactionDTO.getCommission());
		newTransaction.setExchange(transactionDTO.getExchange());
		newTransaction.setTotalCost(transactionDTO.getTotalCost());
		newTransaction.setUnitPrice(transactionDTO.getUnitPrice());
		newTransaction.setUnitPriceXamount(transactionDTO.getUnitPriceXamount());
		newTransaction = transactionRepository.save(newTransaction);
		User user = userService.getUser(transactionDTO.getUser());
		user.getTransactions().add(newTransaction);
		userService.updateUser(user);
		return newTransaction;
	}

}
