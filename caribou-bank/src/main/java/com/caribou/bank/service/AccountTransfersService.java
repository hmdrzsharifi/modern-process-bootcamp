package com.caribou.bank.service;

import com.caribou.bank.domain.AccountTransferTransaction;
import com.caribou.bank.domain.SavingsAccountTransaction;
import com.caribou.bank.domain.SavingsAccountTransactionType;
import com.caribou.bank.repository.AccountTransferTransactionRepository;
import com.caribou.bank.repository.SavingsAccountRepository;
import com.caribou.bank.service.dto.AccountTransferDTO;
import com.caribou.bank.service.dto.AccountTransferTransactionDTO;
import com.caribou.bank.service.dto.SavingsAccountTransactionDTO;
import com.caribou.bank.service.mapper.AccountTransferTransactionMapper;
import com.caribou.bank.service.mapper.SavingsAccountTransactionMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountTransfersService {

    private final SavingsAccountRepository savingsAccountRepository;
    private final SavingsAccountTransactionService savingsAccountTransactionService;
    private final AccountTransferTransactionRepository accountTransferTransactionRepository;
    private final SavingsAccountTransactionMapper savingsAccountTransactionMapper;
    private final AccountTransferTransactionMapper accountTransferTransactionMapper;

    public AccountTransfersService(SavingsAccountRepository savingsAccountRepository, SavingsAccountTransactionService savingsAccountTransactionService, AccountTransferTransactionRepository accountTransferTransactionRepository, SavingsAccountTransactionMapper savingsAccountTransactionMapper, AccountTransferTransactionMapper accountTransferTransactionMapper) {
        this.savingsAccountRepository = savingsAccountRepository;
        this.savingsAccountTransactionService = savingsAccountTransactionService;
        this.accountTransferTransactionRepository = accountTransferTransactionRepository;
        this.savingsAccountTransactionMapper = savingsAccountTransactionMapper;
        this.accountTransferTransactionMapper = accountTransferTransactionMapper;
    }

    @Transactional
    public AccountTransferTransactionDTO handleTransferFunds(AccountTransferDTO accountTransferDTO) {

        SavingsAccountTransactionDTO fromAccountTransactionDTO = new SavingsAccountTransactionDTO();
        fromAccountTransactionDTO.setTransactionType(SavingsAccountTransactionType.WITHDRAWAL);
        fromAccountTransactionDTO.setAmount(accountTransferDTO.getTransactionAmount());
        fromAccountTransactionDTO.setDateOf(accountTransferDTO.getTransactionDate());
        SavingsAccountTransaction fromSavingsAccount = savingsAccountTransactionService.handleWithdraw(accountTransferDTO.getFromAccountId(), fromAccountTransactionDTO);

        SavingsAccountTransactionDTO toAccountTransactionDTO = new SavingsAccountTransactionDTO();
        toAccountTransactionDTO.setTransactionType(SavingsAccountTransactionType.DEPOSIT);
        toAccountTransactionDTO.setAmount(accountTransferDTO.getTransactionAmount());
        toAccountTransactionDTO.setDateOf(accountTransferDTO.getTransactionDate());
        SavingsAccountTransaction toSavingsAccount = savingsAccountTransactionService.handleDeposit(accountTransferDTO.getToAccountId(), toAccountTransactionDTO);;

        AccountTransferTransaction accountTransferTransaction = new AccountTransferTransaction();
        accountTransferTransaction.setDate(accountTransferDTO.getTransactionDate());
        accountTransferTransaction.setAmount(accountTransferDTO.getTransactionAmount());
        accountTransferTransaction.setDescription(accountTransferDTO.getDescription());
        accountTransferTransaction.setFromSavingsTransaction(fromSavingsAccount);
        accountTransferTransaction.setToSavingsTransaction(toSavingsAccount);

        AccountTransferTransaction transferTransaction = accountTransferTransactionRepository.save(accountTransferTransaction);
        AccountTransferTransactionDTO transferTransactionDTO = accountTransferTransactionMapper.toDto(transferTransaction);
        return transferTransactionDTO;
    }
}
