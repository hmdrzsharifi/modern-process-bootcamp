package com.caribou.bank.service;

import com.caribou.bank.domain.AccountTransferTransaction;
import com.caribou.bank.domain.SavingsAccountTransactionType;
import com.caribou.bank.repository.SavingsAccountRepository;
import com.caribou.bank.service.dto.AccountTransferDTO;
import com.caribou.bank.service.dto.SavingsAccountTransactionDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountTransfersService {

    private final SavingsAccountRepository savingsAccountRepository;
    private final SavingsAccountTransactionService savingsAccountTransactionService;
    private final AccountTransferTransactionService accountTransferTransactionService;


    public AccountTransfersService(SavingsAccountRepository savingsAccountRepository, SavingsAccountTransactionService savingsAccountTransactionService, AccountTransferTransactionService accountTransferTransactionService) {
        this.savingsAccountRepository = savingsAccountRepository;
        this.savingsAccountTransactionService = savingsAccountTransactionService;
        this.accountTransferTransactionService = accountTransferTransactionService;
    }

    @Transactional
    public SavingsAccountTransactionDTO handletransferFunds(AccountTransferDTO accountTransferDTO) {

        SavingsAccountTransactionDTO fromAccountTransactionDTO = new SavingsAccountTransactionDTO();
        fromAccountTransactionDTO.setTransactionType(SavingsAccountTransactionType.WITHDRAWAL);
        fromAccountTransactionDTO.setAmount(accountTransferDTO.getTransactionAmount());
        fromAccountTransactionDTO.setDateOf(accountTransferDTO.getTransactionDate());
        SavingsAccountTransactionDTO fromSavingsAccount = savingsAccountTransactionService.handleWithdraw(accountTransferDTO.getFromAccountId(), fromAccountTransactionDTO);

        SavingsAccountTransactionDTO toAccountTransactionDTO = new SavingsAccountTransactionDTO();
        toAccountTransactionDTO.setTransactionType(SavingsAccountTransactionType.DEPOSIT);
        toAccountTransactionDTO.setAmount(accountTransferDTO.getTransactionAmount());
        toAccountTransactionDTO.setDateOf(accountTransferDTO.getTransactionDate());
        SavingsAccountTransactionDTO toSavingsAccount = savingsAccountTransactionService.handleDeposit(accountTransferDTO.getToAccountId(), toAccountTransactionDTO);;

        AccountTransferTransaction accountTransferTransaction = new AccountTransferTransaction();
        accountTransferTransaction.setDate(accountTransferDTO.getTransactionDate());
        accountTransferTransaction.setAmount(accountTransferDTO.getTransactionAmount());
        accountTransferTransaction.setDescription(accountTransferDTO.getDescription());
        accountTransferTransaction.setFromSavingsTransaction(fromSavingsAccount);
        accountTransferTransaction.setToSavingsTransaction(toSavingsAccount);

        accountTransferTransactionService.save(accountTransferTransaction);
    }
}
