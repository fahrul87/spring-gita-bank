package com.fahrul.bank.gita.repository;

import com.fahrul.bank.gita.entity.PrimaryAccount;
import org.springframework.data.repository.CrudRepository;


public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount, Long> {

    PrimaryAccount findByAccountNumber(int accountNumber);
}