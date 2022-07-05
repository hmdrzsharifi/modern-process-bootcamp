package com.caribou.bank.service;

import com.caribou.bank.domain.Office;
import com.caribou.bank.domain.SavingsAccount;
import com.caribou.bank.repository.SavingsAccountRepository;
import com.caribou.bank.service.dto.OfficeDTO;
import com.caribou.bank.service.dto.SavingsAccountDTO;
import com.caribou.bank.service.mapper.SavingsAccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link SavingsAccount}.
 */
@Service
public class SavingsAccountService {

    private final Logger log = LoggerFactory.getLogger(SavingsAccountService.class);

    private final SavingsAccountRepository savingsAccountRepository;

    private final SavingsAccountMapper savingsAccountMapper;

    public SavingsAccountService(SavingsAccountRepository savingsAccountRepository, SavingsAccountMapper savingsAccountMapper) {
        this.savingsAccountRepository = savingsAccountRepository;
        this.savingsAccountMapper = savingsAccountMapper;
    }

    /**
     * Save a savingsAccount.
     *
     * @param savingsAccountDTO the entity to save.
     * @return the persisted entity.
     */
    public SavingsAccountDTO save(SavingsAccountDTO savingsAccountDTO) {
        log.debug("Request to save SavingsAccount : {}", savingsAccountDTO);
        SavingsAccount savingsAccount = savingsAccountMapper.toEntity(savingsAccountDTO);
        savingsAccount = savingsAccountRepository.save(savingsAccount);
        return savingsAccountMapper.toDto(savingsAccount);
    }

    /**
     * Update a savingsAccount.
     *
     * @param savingsAccountDTO the entity to update.
     * @return the updated entity.
     */
    public SavingsAccountDTO update(SavingsAccountDTO savingsAccountDTO) {
        log.debug("Request to update office: {}", savingsAccountDTO);
        SavingsAccount savingsAccount = savingsAccountMapper.toEntity(savingsAccountDTO);
        savingsAccount = savingsAccountRepository.save(savingsAccount);
        return savingsAccountMapper.toDto(savingsAccount);
    }

    /**
     * Get all the savingsAccounts.
     *
     * @return the list of entities.
     */
    public List<SavingsAccountDTO> findAll() {
        log.debug("Request to get all SavingsAccounts");
        return savingsAccountRepository.findAll().stream()
                .map(savingsAccountMapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one savingsAccount by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<SavingsAccountDTO> findOne(Long id) {
        log.debug("Request to get SavingsAccount : {}", id);
        return savingsAccountRepository.findById(id)
                .map(savingsAccountMapper::toDto);
    }

    /**
     * Delete the savingsAccount by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete SavingsAccount : {}", id);
        savingsAccountRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return savingsAccountRepository.existsById(id);
    }

}
