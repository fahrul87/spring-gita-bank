package com.fahrul.bank.gita.repository;

import com.fahrul.bank.gita.entity.SavingsAccount;
import org.springframework.data.repository.CrudRepository;


public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber(int accountNumber);
}