package com.factorit.crypto.crypto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.factorit.crypto.crypto.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>{

}
