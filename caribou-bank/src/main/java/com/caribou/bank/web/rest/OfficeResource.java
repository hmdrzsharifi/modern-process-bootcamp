package com.caribou.bank.web.rest;

import com.caribou.bank.domain.Office;
import com.caribou.bank.repository.OfficeRepository;
import com.caribou.bank.service.OfficeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OfficeResource {

    private final Logger log = LoggerFactory.getLogger(OfficeResource.class);

    private  final OfficeService officeService;

    public OfficeResource(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("/offices")
    public Office createOffice(@RequestBody Office office){
        log.debug("REST request to save office : {}", office);
        Office result = officeService.save(office);
        return result;
    }
}
