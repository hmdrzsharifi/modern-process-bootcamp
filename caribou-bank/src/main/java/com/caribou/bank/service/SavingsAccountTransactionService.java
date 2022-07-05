package com.caribou.bank.service;

import com.caribou.bank.domain.SavingsAccount;
import com.caribou.bank.domain.SavingsAccountStatusType;
import com.caribou.bank.domain.SavingsAccountTransaction;
import com.caribou.bank.repository.SavingsAccountRepository;
import com.caribou.bank.repository.SavingsAccountTransactionRepository;
import com.caribou.bank.service.dto.SavingsAccountTransactionDTO;
import com.caribou.bank.service.mapper.SavingsAccountTransactionMapper;
import com.caribou.bank.web.rest.errors.SavingsAccountBlockedException;
import com.caribou.bank.web.rest.errors.SavingsAccountNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SavingsAccountTransactionService {

    private final Logger log = LoggerFactory.getLogger(SavingsAccountTransactionService.class);

    private final SavingsAccountTransactionRepository savingsAccountTransactionRepository;

    private final SavingsAccountTransactionMapper savingsAccountTransactionMapper;

    private final SavingsAccountRepository savingsAccountRepository;

    public SavingsAccountTransactionService(SavingsAccountTransactionRepository savingsAccountTransactionRepository, SavingsAccountTransactionMapper savingsAccountTransactionMapper, SavingsAccountRepository savingsAccountRepository) {
        this.savingsAccountTransactionRepository = savingsAccountTransactionRepository;
        this.savingsAccountTransactionMapper = savingsAccountTransactionMapper;
        this.savingsAccountRepository = savingsAccountRepository;
    }

    public List<SavingsAccountTransactionDTO> findAll() {
        log.debug("Request to get all SavingsAccountTransactions");
        return savingsAccountTransactionRepository.findAll().stream()
            .map(savingsAccountTransactionMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    public SavingsAccountTransaction handleDeposit(Long savingsId, SavingsAccountTransactionDTO savingsAccountTransactionDTO) {

       SavingsAccountTransaction savingsAccountTransaction;
       Optional<SavingsAccount> retSavingsAccount = savingsAccountRepository.findById(savingsId);
       if (retSavingsAccount.isPresent()){
           SavingsAccount savingsAccount = retSavingsAccount.get();
           validateForAccountBlock(savingsAccount);

           // save account transaction
           savingsAccountTransaction = savingsAccountTransactionMapper.toEntity(savingsAccountTransactionDTO);
           savingsAccountTransaction.setSavingsAccount(savingsAccount);
           savingsAccountTransaction = savingsAccountTransactionRepository.save(savingsAccountTransaction);

           // update balance
           savingsAccount.setAccountBalance(savingsAccountTransaction.getAmount().add(savingsAccount.getAccountBalance()));
           savingsAccountRepository.save(savingsAccount);
       } else {
           throw new SavingsAccountNotFoundException("Savings account not found", savingsId.toString(), "accountnotfound");
       }

       return savingsAccountTransaction;
    }

    public SavingsAccountTransaction handleWithdraw(Long savingsId, SavingsAccountTransactionDTO savingsAccountTransactionDTO) {
        SavingsAccountTransaction savingsAccountTransaction;
        Optional<SavingsAccount> retSavingsAccount = savingsAccountRepository.findById(savingsId);
        if (retSavingsAccount.isPresent()){
            SavingsAccount savingsAccount = retSavingsAccount.get();
            validateForAccountBlock(savingsAccount);

            // save account transaction
            savingsAccountTransaction = savingsAccountTransactionMapper.toEntity(savingsAccountTransactionDTO);
            savingsAccountTransaction.setSavingsAccount(savingsAccount);
            savingsAccountTransaction = savingsAccountTransactionRepository.save(savingsAccountTransaction);

            // update balance
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(savingsAccountTransaction.getAmount()));
            savingsAccountRepository.save(savingsAccount);
        } else {
            throw new SavingsAccountNotFoundException("Savings account not found", savingsId.toString(), "accountnotfound");
        }

        return savingsAccountTransaction;
    }

    private void validateForAccountBlock(SavingsAccount savingsAccount) {
        final SavingsAccountStatusType currentStatus = savingsAccount.getStatus();
        if (SavingsAccountStatusType.BLOCK.equals(currentStatus)){
            throw new SavingsAccountBlockedException("Savings account blocked", savingsAccount.getId().toString(), "accountblocked");
        }
    }

}
