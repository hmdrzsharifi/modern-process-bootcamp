package com.caribou.bank.service;

import com.caribou.bank.domain.AccountTransferTransaction;
import com.caribou.bank.repository.AccountTransferTransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AccountTransferTransactionService {

    private final Logger log = LoggerFactory.getLogger(AccountTransferTransactionService.class);

    private final AccountTransferTransactionRepository accountTransferTransactionRepository;


    public AccountTransferTransactionService(AccountTransferTransactionRepository accountTransferTransactionRepository) {
        this.accountTransferTransactionRepository = accountTransferTransactionRepository;
    }

    public void save(AccountTransferTransaction accountTransferTransaction) {


    }
}
