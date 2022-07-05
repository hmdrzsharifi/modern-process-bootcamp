package com.caribou.bank.web.rest;

import com.caribou.bank.config.HeaderUtil;
import com.caribou.bank.config.ResponseUtil;
import com.caribou.bank.service.SavingsAccountService;
import com.caribou.bank.service.dto.SavingsAccountDTO;
import com.caribou.bank.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.caribou.bank.domain.SavingsAccount}.
 */
@RestController
@RequestMapping("/api")
public class SavingsAccountResource {

    private final Logger log = LoggerFactory.getLogger(SavingsAccountResource.class);

    private static final String ENTITY_NAME = "savingsAccount";

    @Value("${caribou.clientApp.name}")
    private String applicationName;

    private final SavingsAccountService savingsAccountService;

    public SavingsAccountResource(SavingsAccountService savingsAccountService) {
        this.savingsAccountService = savingsAccountService;
    }

    /**
     * {@code POST  /savings-accounts} : Create a new savingsAccount.
     *
     * @param savingsAccountDTO the savingsAccountDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new savingsAccountDTO, or with status {@code 400 (Bad Request)} if the savingsAccount has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/savings-accounts")
    public ResponseEntity<SavingsAccountDTO> createSavingsAccount(@Valid @RequestBody SavingsAccountDTO savingsAccountDTO) throws URISyntaxException {
        log.debug("REST request to save SavingsAccount : {}", savingsAccountDTO);
        if (savingsAccountDTO.getId() != null) {
            throw new BadRequestAlertException("A new savingsAccount cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SavingsAccountDTO result = savingsAccountService.save(savingsAccountDTO);
        return ResponseEntity.created(new URI("/api/savings-accounts/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    /**
     * {@code PUT  /savings-accounts} : Updates an existing savingsAccount.
     *
     * @param savingsAccountDTO the savingsAccountDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated savingsAccountDTO,
     * or with status {@code 400 (Bad Request)} if the savingsAccountDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the savingsAccountDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/savings-accounts")
    public ResponseEntity<SavingsAccountDTO> updateSavingsAccount(@Valid @RequestBody SavingsAccountDTO savingsAccountDTO) throws URISyntaxException {
        log.debug("REST request to update SavingsAccount : {}", savingsAccountDTO);
        if (savingsAccountDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!savingsAccountService.existsById(savingsAccountDTO.getId())){
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        SavingsAccountDTO result = savingsAccountService.update(savingsAccountDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, savingsAccountDTO.getId().toString()))
                .body(result);
    }

    /**
     * {@code GET  /savings-accounts} : get all the savingsAccounts.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of savingsAccounts in body.
     */
    @GetMapping("/savings-accounts")
    public List<SavingsAccountDTO> getAllSavingsAccounts() {
        log.debug("REST request to get all SavingsAccounts");
        return savingsAccountService.findAll();
    }

    /**
     * {@code GET  /savings-accounts/:id} : get the "id" savingsAccount.
     *
     * @param id the id of the savingsAccountDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the savingsAccountDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/savings-accounts/{id}")
    public ResponseEntity<SavingsAccountDTO> getSavingsAccount(@PathVariable Long id) {
        log.debug("REST request to get SavingsAccount : {}", id);
        Optional<SavingsAccountDTO> savingsAccountDTO = savingsAccountService.findOne(id);
        return ResponseUtil.wrapOrNotFound(savingsAccountDTO);
    }

    /**
     * {@code DELETE  /savings-accounts/:id} : delete the "id" savingsAccount.
     *
     * @param id the id of the savingsAccountDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/savings-accounts/{id}")
    public ResponseEntity<Void> deleteSavingsAccount(@PathVariable Long id) {
        log.debug("REST request to delete SavingsAccount : {}", id);
        savingsAccountService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
