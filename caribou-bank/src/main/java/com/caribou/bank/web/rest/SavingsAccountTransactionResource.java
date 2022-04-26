package com.caribou.bank.web.rest;


import com.caribou.bank.config.HeaderUtil;
import com.caribou.bank.domain.SavingsAccountTransaction;
import com.caribou.bank.service.SavingsAccountTransactionService;
import com.caribou.bank.service.dto.SavingsAccountTransactionDTO;
import com.caribou.bank.service.mapper.SavingsAccountTransactionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SavingsAccountTransactionResource {

    private final Logger log = LoggerFactory.getLogger(SavingsAccountTransactionResource.class);

    private static final String ENTITY_NAME = "savingsAccountTransaction";

    @Value("${caribou.clientApp.name}")
    private String applicationName;

    private final SavingsAccountTransactionService savingsAccountTransactionService;
    private final SavingsAccountTransactionMapper savingsAccountTransactionMapper;

    public SavingsAccountTransactionResource(SavingsAccountTransactionService savingsAccountTransactionService, SavingsAccountTransactionMapper savingsAccountTransactionMapper) {
        this.savingsAccountTransactionService = savingsAccountTransactionService;
        this.savingsAccountTransactionMapper = savingsAccountTransactionMapper;
    }

    @GetMapping("/savings-account-tranactions")
    public List<SavingsAccountTransactionDTO> getAllSavingsAccountTransactions(){
        log.debug("REST request to get all SavingsAccountTransaction");
        return savingsAccountTransactionService.findAll();
    }

    @PostMapping("/savings-account-tranactions/{savingsId}/deposit")
    public ResponseEntity<SavingsAccountTransactionDTO> deposit(@PathVariable Long savingsId, @RequestBody SavingsAccountTransactionDTO savingsAccountTransactionDTO) throws URISyntaxException {
        log.debug("REST request to deposit to SavingsAccount : {}", savingsAccountTransactionDTO);

        SavingsAccountTransaction savingsAccountTransaction = savingsAccountTransactionService.handleDeposit(savingsId, savingsAccountTransactionDTO);
        SavingsAccountTransactionDTO result = savingsAccountTransactionMapper.toDto(savingsAccountTransaction);
        return ResponseEntity.created(new URI("/api/savings-account-tranactions" + result))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.toString()))
            .body(result);

    }

    @PostMapping("/savings-account-tranactions/{savingsId}/withdraw")
    public ResponseEntity<SavingsAccountTransactionDTO> withdraw(@PathVariable Long savingsId, @RequestBody SavingsAccountTransactionDTO savingsAccountTransactionDTO) throws URISyntaxException {
        log.debug("REST request to withdraw to SavingsAccount : {}", savingsAccountTransactionDTO);

        SavingsAccountTransaction savingsAccountTransaction = savingsAccountTransactionService.handleWithdraw(savingsId, savingsAccountTransactionDTO);
        SavingsAccountTransactionDTO result = savingsAccountTransactionMapper.toDto(savingsAccountTransaction);

        return ResponseEntity.created(new URI("/api/savings-account-tranactions" + result))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.toString()))
                .body(result);

    }
}
