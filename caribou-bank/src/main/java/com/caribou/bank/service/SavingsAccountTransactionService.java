package com.caribou.bank.service;

import com.caribou.bank.domain.SavingsAccount;
import com.caribou.bank.domain.SavingsAccountTransaction;
import com.caribou.bank.repository.SavingsAccountRepository;
import com.caribou.bank.repository.SavingsAccountTransactionRepository;
import com.caribou.bank.service.dto.SavingsAccountTransactionDTO;
import com.caribou.bank.service.mapper.SavingsAccountTransactionMapper;
import com.caribou.bank.web.rest.errors.BadRequestAlertException;
import com.caribou.bank.web.rest.errors.SavingsAccountNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link SavingsAccountTransaction}.
 */
@Service
public class SavingsAccountTransactionService {

    private final Logger log = LoggerFactory.getLogger(SavingsAccountTransactionService.class);

    private final SavingsAccountTransactionRepository savingsAccountTransactionRepository;

    private final SavingsAccountRepository savingsAccountRepository;

    private final SavingsAccountTransactionMapper savingsAccountTransactionMapper;

    public SavingsAccountTransactionService(SavingsAccountTransactionRepository savingsAccountTransactionRepository, SavingsAccountRepository savingsAccountRepository, SavingsAccountTransactionMapper savingsAccountTransactionMapper) {
        this.savingsAccountTransactionRepository = savingsAccountTransactionRepository;
        this.savingsAccountRepository = savingsAccountRepository;
        this.savingsAccountTransactionMapper = savingsAccountTransactionMapper;
    }

    /**
     * Save a savingsAccountTransaction.
     *
     * @param savingsAccountTransactionDTO the entity to save.
     * @return the persisted entity.
     */
    public SavingsAccountTransactionDTO save(SavingsAccountTransactionDTO savingsAccountTransactionDTO) {
        log.debug("Request to save SavingsAccountTransaction : {}", savingsAccountTransactionDTO);
        SavingsAccountTransaction savingsAccountTransaction = savingsAccountTransactionMapper.toEntity(savingsAccountTransactionDTO);
        savingsAccountTransaction = savingsAccountTransactionRepository.save(savingsAccountTransaction);
        return savingsAccountTransactionMapper.toDto(savingsAccountTransaction);
    }

    /**
     * Update a savingsAccountTransaction.
     *
     * @param savingsAccountTransactionDTO the entity to update.
     * @return the updated entity.
     */
    public SavingsAccountTransactionDTO update(SavingsAccountTransactionDTO savingsAccountTransactionDTO) {
        log.debug("Request to update office: {}", savingsAccountTransactionDTO);
        SavingsAccountTransaction savingsAccountTransaction = savingsAccountTransactionMapper.toEntity(savingsAccountTransactionDTO);
        savingsAccountTransaction = savingsAccountTransactionRepository.save(savingsAccountTransaction);
        return savingsAccountTransactionMapper.toDto(savingsAccountTransaction);
    }

    /**
     * Get all the savingsAccountTransactions.
     *
     * @return the list of entities.
     */
    public List<SavingsAccountTransactionDTO> findAll() {
        log.debug("Request to get all SavingsAccountTransactions");
        return savingsAccountTransactionRepository.findAll().stream()
                .map(savingsAccountTransactionMapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one savingsAccountTransaction by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<SavingsAccountTransactionDTO> findOne(Long id) {
        log.debug("Request to get SavingsAccountTransaction : {}", id);
        return savingsAccountTransactionRepository.findById(id)
                .map(savingsAccountTransactionMapper::toDto);
    }

    /**
     * Delete the savingsAccountTransaction by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete SavingsAccountTransaction : {}", id);
        savingsAccountTransactionRepository.deleteById(id);
    }


    public boolean existsById(Long id) {
        return savingsAccountTransactionRepository.existsById(id);
    }

    @Transactional
    public SavingsAccountTransactionDTO handleDeposit(Long savingsId, SavingsAccountTransactionDTO savingsAccountTransactionDTO) {

        if (!savingsAccountRepository.existsById(savingsId)){
            throw new SavingsAccountNotFoundException("Savings account not found", savingsId.toString(), "idnotfound");
        }

        SavingsAccount savingsAccount = savingsAccountRepository.getById(savingsId);
        savingsAccount.validateForAccountBlock();

        SavingsAccountTransaction savingsAccountTransaction = savingsAccountTransactionMapper.toEntity(savingsAccountTransactionDTO);
        savingsAccountTransaction = savingsAccountTransactionRepository.save(savingsAccountTransaction);
        savingsAccountTransactionDTO = savingsAccountTransactionMapper.toDto(savingsAccountTransaction);

        savingsAccount.setAccountBalance(savingsAccountTransactionDTO.getAmount().add(savingsAccount.getAccountBalance()));
        savingsAccountRepository.save(savingsAccount);

        return savingsAccountTransactionDTO;
    }

    @Transactional
    public SavingsAccountTransactionDTO handleWithdraw(Long savingsId, SavingsAccountTransactionDTO savingsAccountTransactionDTO) {
        if (!savingsAccountRepository.existsById(savingsId)){
            throw new SavingsAccountNotFoundException("Savings account not found", savingsId.toString(), "idnotfound");
        }

        SavingsAccount savingsAccount = savingsAccountRepository.getById(savingsId);
        savingsAccount.validateForAccountBlock();

        SavingsAccountTransaction savingsAccountTransaction = savingsAccountTransactionMapper.toEntity(savingsAccountTransactionDTO);
        savingsAccountTransaction = savingsAccountTransactionRepository.save(savingsAccountTransaction);
        savingsAccountTransactionDTO = savingsAccountTransactionMapper.toDto(savingsAccountTransaction);

        savingsAccount.setAccountBalance(savingsAccountTransactionDTO.getAmount().subtract(savingsAccount.getAccountBalance()));
        savingsAccountRepository.save(savingsAccount);

        return savingsAccountTransactionDTO;

    }
}
