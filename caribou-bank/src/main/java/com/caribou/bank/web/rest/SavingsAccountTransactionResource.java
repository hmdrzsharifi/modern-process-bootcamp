package com.caribou.bank.web.rest;

import com.caribou.bank.config.HeaderUtil;
import com.caribou.bank.config.ResponseUtil;
import com.caribou.bank.service.SavingsAccountTransactionService;
import com.caribou.bank.service.dto.SavingsAccountDTO;
import com.caribou.bank.service.dto.SavingsAccountTransactionDTO;
import com.caribou.bank.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.caribou.bank.domain.SavingsAccountTransaction}.
 */
@RestController
@RequestMapping("/api")
public class SavingsAccountTransactionResource {

    private final Logger log = LoggerFactory.getLogger(SavingsAccountTransactionResource.class);

    private static final String ENTITY_NAME = "savingsAccountTransaction";

    @Value("${caribou.clientApp.name}")
    private String applicationName;

    private final SavingsAccountTransactionService savingsAccountTransactionService;

    public SavingsAccountTransactionResource(SavingsAccountTransactionService savingsAccountTransactionService) {
        this.savingsAccountTransactionService = savingsAccountTransactionService;
    }

    /**
     * {@code POST  /savings-account-transactions} : Create a new savingsAccountTransaction.
     *
     * @param savingsAccountTransactionDTO the savingsAccountTransactionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new savingsAccountTransactionDTO, or with status {@code 400 (Bad Request)} if the savingsAccountTransaction has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
   /* @PostMapping("/savings-account-transactions")
    public ResponseEntity<SavingsAccountTransactionDTO> createSavingsAccountTransaction(@RequestBody SavingsAccountTransactionDTO savingsAccountTransactionDTO) throws URISyntaxException {
        log.debug("REST request to save SavingsAccountTransaction : {}", savingsAccountTransactionDTO);
        if (savingsAccountTransactionDTO.getId() != null) {
            throw new BadRequestAlertException("A new savingsAccountTransaction cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SavingsAccountTransactionDTO result = savingsAccountTransactionService.save(savingsAccountTransactionDTO);
        return ResponseEntity.created(new URI("/api/savings-account-transactions/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }*/

    /**
     * {@code PUT  /savings-account-transactions} : Updates an existing savingsAccountTransaction.
     *
     * @param savingsAccountTransactionDTO the savingsAccountTransactionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated savingsAccountTransactionDTO,
     * or with status {@code 400 (Bad Request)} if the savingsAccountTransactionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the savingsAccountTransactionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
   /* @PutMapping("/savings-account-transactions")
    public ResponseEntity<SavingsAccountTransactionDTO> updateSavingsAccountTransaction(@RequestBody SavingsAccountTransactionDTO savingsAccountTransactionDTO) throws URISyntaxException {
        log.debug("REST request to update SavingsAccountTransaction : {}", savingsAccountTransactionDTO);
        if (savingsAccountTransactionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!savingsAccountTransactionService.existsById(savingsAccountTransactionDTO.getId())){
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        SavingsAccountTransactionDTO result = savingsAccountTransactionService.update(savingsAccountTransactionDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, savingsAccountTransactionDTO.getId().toString()))
                .body(result);
    }*/

    /**
     * {@code GET  /savings-account-transactions} : get all the savingsAccountTransactions.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of savingsAccountTransactions in body.
     */
    @GetMapping("/savings-account-transactions")
    public List<SavingsAccountTransactionDTO> getAllSavingsAccountTransactions() {
        log.debug("REST request to get all SavingsAccountTransactions");
        return savingsAccountTransactionService.findAll();
    }

    /**
     * {@code GET  /savings-account-transactions/:id} : get the "id" savingsAccountTransaction.
     *
     * @param id the id of the savingsAccountTransactionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the savingsAccountTransactionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/savings-account-transactions/{id}")
    public ResponseEntity<SavingsAccountTransactionDTO> getSavingsAccountTransaction(@PathVariable Long id) {
        log.debug("REST request to get SavingsAccountTransaction : {}", id);
        Optional<SavingsAccountTransactionDTO> savingsAccountTransactionDTO = savingsAccountTransactionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(savingsAccountTransactionDTO);
    }

    /**
     * {@code DELETE  /savings-account-transactions/:id} : delete the "id" savingsAccountTransaction.
     *
     * @param id the id of the savingsAccountTransactionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/savings-account-transactions/{id}")
    public ResponseEntity<Void> deleteSavingsAccountTransaction(@PathVariable Long id) {
        log.debug("REST request to delete SavingsAccountTransaction : {}", id);
        savingsAccountTransactionService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code POST  /savings-account-transactions} : Create a new savingsAccountTransaction.
     *
     * @param savingsAccountTransactionDTO the savingsAccountTransactionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new savingsAccountTransactionDTO, or with status {@code 400 (Bad Request)} if the savingsAccountTransaction has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/savings-account-transactions/{savingsId}/deposit")
    public ResponseEntity<SavingsAccountTransactionDTO> deposit(@PathVariable Long savingsId, @RequestBody SavingsAccountTransactionDTO savingsAccountTransactionDTO) throws URISyntaxException {
        log.debug("REST request to deposit to SavingsAccount : {}", savingsAccountTransactionDTO);
        /*if (savingsAccountTransactionDTO.getId() != null) {
            throw new BadRequestAlertException("A new savingsAccountTransaction cannot already have an ID", ENTITY_NAME, "idexists");
        }*/

        SavingsAccountTransactionDTO result = savingsAccountTransactionService.handleDeposit(savingsId, savingsAccountTransactionDTO);
        return ResponseEntity.created(new URI("/api/savings-account-transactions/" + result))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.toString()))
                .body(result);
    }

    /**
     * {@code POST  /savings-account-transactions} : Create a new savingsAccountTransaction.
     *
     * @param savingsAccountTransactionDTO the savingsAccountTransactionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new savingsAccountTransactionDTO, or with status {@code 400 (Bad Request)} if the savingsAccountTransaction has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/savings-account-transactions/{savingsId}/withdraw")
    public ResponseEntity<SavingsAccountTransactionDTO> withdraw(@PathVariable Long savingsId, @RequestBody SavingsAccountTransactionDTO savingsAccountTransactionDTO) throws URISyntaxException {
        log.debug("REST request to withdraw to SavingsAccount : {}", savingsAccountTransactionDTO);
        /*if (savingsAccountTransactionDTO.getId() != null) {
            throw new BadRequestAlertException("A new savingsAccountTransaction cannot already have an ID", ENTITY_NAME, "idexists");
        }*/

        SavingsAccountTransactionDTO result = savingsAccountTransactionService.handleWithdraw(savingsId, savingsAccountTransactionDTO);
        return ResponseEntity.created(new URI("/api/savings-account-transactions/" + result))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.toString()))
                .body(result);
    }

}
