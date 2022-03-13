package com.caribou.bank.service;

import com.caribou.bank.domain.Office;
import com.caribou.bank.repository.OfficeRepository;
import com.caribou.bank.service.dto.OfficeDTO;
import com.caribou.bank.service.mapper.OfficeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OfficeService {

    private final Logger log = LoggerFactory.getLogger(OfficeService.class);

    private final OfficeRepository officeRepository;

    private final OfficeMapper officeMapper;

    public OfficeService(OfficeRepository officeRepository, OfficeMapper officeMapper) {
        this.officeRepository = officeRepository;
        this.officeMapper = officeMapper;
    }

    public OfficeDTO save(OfficeDTO officeDTO) {
        log.debug("Request to save office: {}", officeDTO);
        // mapping DTO to Entity
        Office office = officeMapper.toEntity(officeDTO);

        office = officeRepository.save(office);

        // mapping Entity to DTO

        return officeMapper.toDto(office);
    }

}
