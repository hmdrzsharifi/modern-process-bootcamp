package com.caribou.bank.web.rest;

import com.caribou.bank.service.OfficeService;
import com.caribou.bank.service.dto.OfficeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OfficeResource {

    private final Logger log = LoggerFactory.getLogger(OfficeResource.class);

    private  final OfficeService officeService;

    public OfficeResource(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("/offices")
    public OfficeDTO createOffice(@RequestBody OfficeDTO officeDTO){
        log.debug("REST request to save office : {}", officeDTO);
        OfficeDTO result = officeService.save(officeDTO);
        return result;
    }
}
