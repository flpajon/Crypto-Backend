package com.factorit.crypto.crypto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.factorit.crypto.crypto.dto.TransactionDTO;
import com.factorit.crypto.crypto.model.Transaction;
import com.factorit.crypto.crypto.service.transaction.TransactionService_impl;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {
	
	private final static Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	@Autowired
	private TransactionService_impl transactionService;
	
	@RequestMapping(method = RequestMethod.PUT, value = "/new")
	public ResponseEntity<?> newUserTransaction(@RequestBody TransactionDTO transactionDTO) {
		try {
			return new ResponseEntity<Transaction>(transactionService.newUserTransaction(transactionDTO), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.toString());
			return new ResponseEntity<String>(new String("Ocurrio un problema."), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
