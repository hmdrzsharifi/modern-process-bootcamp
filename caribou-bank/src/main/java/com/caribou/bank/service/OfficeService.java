package com.caribou.bank.service;

import com.caribou.bank.domain.Office;
import com.caribou.bank.repository.OfficeRepository;
import com.caribou.bank.service.dto.OfficeDTO;
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

    public OfficeDTO save(OfficeDTO officeDTO) {
        log.debug("Request to save office: {}", officeDTO);
        // mapping DTO to Entity
        Office office = new Office();
        office.setId(officeDTO.getId());
        office.setName(officeDTO.getName());
        office.setOpeningDate(officeDTO.getOpeningDate());
        office.setExternalId(officeDTO.getExternalId());
        office.setParent(fromId(officeDTO.getParentId()));

        Office office1 = officeRepository.save(office);

        // mapping Entity to DTO
        OfficeDTO officeDTO1 = new OfficeDTO();
        officeDTO1.setId(office1.getId());
        officeDTO1.setName(office1.getName());
        officeDTO1.setOpeningDate(office1.getOpeningDate());
        officeDTO1.setExternalId(office1.getExternalId());

        return officeDTO1;
    }

    private Office fromId(Long id) {
        if (id == null){
            return null;
        }
        Office office = new Office();
        office.setId(id);
        return office;

    }
}
