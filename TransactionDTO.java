package com.achila.ETLloadservice.repository;

import com.achila.ETLloadservice.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDTO extends CrudRepository<Transaction,Integer> {
}
