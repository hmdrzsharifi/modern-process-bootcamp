package com.caribou.bank.web.rest;

import com.caribou.bank.config.HeaderUtil;
import com.caribou.bank.config.ResponseUtil;
import com.caribou.bank.service.OfficeService;
import com.caribou.bank.service.dto.OfficeDTO;
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
 * REST controller for managing {@link com.caribou.bank.domain.Office}.
 */
@RestController
@RequestMapping("/api")
public class OfficeResource {

    private final Logger log = LoggerFactory.getLogger(OfficeResource.class);

    private static final String ENTITY_NAME = "office";

    @Value("${caribou.clientApp.name}")
    private String applicationName;

    private  final OfficeService officeService;

    public OfficeResource(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * {@code POST /offices} : Create a new office.
     *
     * @param officeDTO the officeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created) and with body the new officeDTO, or with status {@code 400 (Bad Request)} if the office has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/offices")
    public ResponseEntity<OfficeDTO> createOffice(@Valid @RequestBody OfficeDTO officeDTO) throws URISyntaxException {
        log.debug("REST request to save office : {}", officeDTO);
        if (officeDTO.getId() != null){
            throw new BadRequestAlertException("A new office cannot already have an ID", ENTITY_NAME, "idexsists");
        }
        OfficeDTO result = officeService.save(officeDTO);
        return ResponseEntity.created(new URI("/api/offices/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    /**
     * {@code PUT  /offices} : Updates an existing office.
     *
     * @param officeDTO the officeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated officeDTO,
     * or with status {@code 400 (Bad Request)} if the officeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the officeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/offices")
    public ResponseEntity<OfficeDTO> updateOffice(@Valid @RequestBody OfficeDTO officeDTO) {
        log.debug("REST request to update Office : {}", officeDTO);
        if (officeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!officeService.existsById(officeDTO.getId())){
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        OfficeDTO result = officeService.update(officeDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, officeDTO.getId().toString()))
                .body(result);
    }

    /**
     * {@code GET  /offices} : get all the offices.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of offices in body.
     */
    @GetMapping("/offices")
    public List<OfficeDTO> getAllOffices() {
        log.debug("REST request to get all Offices");
        return officeService.findAll();
    }

    /**
     * {@code GET  /offices/:id} : get the "id" office.
     *
     * @param id the id of the officeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the officeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/offices/{id}")
    public ResponseEntity<OfficeDTO> getOffice(@PathVariable Long id) {
        log.debug("REST request to get Office : {}", id);
        Optional<OfficeDTO> officeDTO = officeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(officeDTO);
    }

    /**
     * {@code DELETE  /offices/:id} : delete the "id" office.
     *
     * @param id the id of the officeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/offices/{id}")
    public ResponseEntity<Void> deleteOffice(@PathVariable Long id) {
        log.debug("REST request to delete Office : {}", id);
        officeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
