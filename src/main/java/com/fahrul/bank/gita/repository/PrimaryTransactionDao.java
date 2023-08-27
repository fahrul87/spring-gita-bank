package com.fahrul.bank.gita.repository;

import com.fahrul.bank.gita.entity.PrimaryTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {

    List<PrimaryTransaction> findAll();
}