package com.fahrul.bank.gita.repository;

import com.fahrul.bank.gita.entity.SavingsTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {

    List<SavingsTransaction> findAll();
}