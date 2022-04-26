package com.caribou.bank.web.rest;

import com.caribou.bank.config.HeaderUtil;
import com.caribou.bank.service.AccountTransfersService;
import com.caribou.bank.service.SavingsAccountTransactionService;
import com.caribou.bank.service.dto.AccountTransferDTO;
import com.caribou.bank.service.dto.AccountTransferTransactionDTO;
import com.caribou.bank.service.dto.SavingsAccountTransactionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class AccountTransfersResource {

    private final Logger log = LoggerFactory.getLogger(AccountTransfersResource.class);

    private final AccountTransfersService accountTransfersService;

    public AccountTransfersResource(AccountTransfersService accountTransfersService) {
        this.accountTransfersService = accountTransfersService;
    }

    @PostMapping("/account-transfers")
    public ResponseEntity<AccountTransferTransactionDTO> transferFunds(@RequestBody AccountTransferDTO accountTransferDTO) throws URISyntaxException {
        log.debug("REST request to transferFunds from SavingsAccount to SavingsAccount: {}", accountTransferDTO);
        /*if (savingsAccountTransactionDTO.getId() != null) {
            throw new BadRequestAlertException("A new savingsAccountTransaction cannot already have an ID", ENTITY_NAME, "idexists");
        }*/

        AccountTransferTransactionDTO result = accountTransfersService.handleTransferFunds(accountTransferDTO);
        return ResponseEntity.created(new URI("/api/savings-account-transactions/" + result))
                //.headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.toString()))
                .body(result);
    }
}
