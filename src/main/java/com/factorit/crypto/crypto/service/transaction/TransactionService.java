package com.factorit.crypto.crypto.service.transaction;

import com.factorit.crypto.crypto.dto.TransactionDTO;
import com.factorit.crypto.crypto.model.Transaction;

public interface TransactionService {

	public Transaction newUserTransaction(TransactionDTO transactionDTO);
}
