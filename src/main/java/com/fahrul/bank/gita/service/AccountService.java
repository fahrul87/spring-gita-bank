package com.fahrul.bank.gita.service;

import com.fahrul.bank.gita.entity.PrimaryAccount;
import com.fahrul.bank.gita.entity.SavingsAccount;

import java.security.Principal;


public interface AccountService {

    PrimaryAccount createPrimaryAccount();

    SavingsAccount createSavingsAccount();

    void deposit(String accountType, double amount, Principal principal);

    void withdraw(String accountType, double amount, Principal principal);

}