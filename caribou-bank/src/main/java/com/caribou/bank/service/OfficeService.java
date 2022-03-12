package com.caribou.bank.service;

import com.caribou.bank.domain.Office;
import com.caribou.bank.repository.OfficeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OfficeService {

    private final Logger log = LoggerFactory.getLogger(OfficeService.class);

    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public Office save(Office office) {
        log.debug("Request to save office: {}", office);
        Office office1 = officeRepository.save(office);
        return office1;
    }
}
