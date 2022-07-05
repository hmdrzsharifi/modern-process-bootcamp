package com.caribou.bank.service;

import com.caribou.bank.domain.Office;
import com.caribou.bank.repository.OfficeRepository;
import com.caribou.bank.service.dto.OfficeDTO;
import com.caribou.bank.service.mapper.OfficeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Office}.
 */
@Service
public class OfficeService {

    private final Logger log = LoggerFactory.getLogger(OfficeService.class);

    private final OfficeRepository officeRepository;

    private final OfficeMapper officeMapper;

    public OfficeService(OfficeRepository officeRepository, OfficeMapper officeMapper) {
        this.officeRepository = officeRepository;
        this.officeMapper = officeMapper;
    }

    /**
     * Save an office.
     *
     * @param officeDTO the entity to save.
     * @return the persisted entity.
     */
    public OfficeDTO save(OfficeDTO officeDTO) {
        log.debug("Request to save office: {}", officeDTO);
        // mapping DTO to Entity
        Office office = officeMapper.toEntity(officeDTO);
        office = officeRepository.save(office);
        // mapping Entity to DTO
        return officeMapper.toDto(office);
    }

    /**
     * Update an office.
     *
     * @param officeDTO the entity to update.
     * @return the updated entity.
     */
    public OfficeDTO update(OfficeDTO officeDTO) {
        log.debug("Request to update office: {}", officeDTO);
        Office office = officeMapper.toEntity(officeDTO);
        office = officeRepository.save(office);
        return officeMapper.toDto(office);
    }

    /**
     * Get all the offices.
     *
     * @return the list of entities.
     */
    public List<OfficeDTO> findAll() {
        log.debug("Request to get all offices");
        return officeRepository.findAll().stream()
            .map(officeMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one office by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<OfficeDTO> findOne(Long id) {
        log.debug("Request to get Office : {}", id);
        return officeRepository.findById(id).map(officeMapper::toDto);
    }

    /**
     * Delete the office by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Office : {}", id);
        officeRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return officeRepository.existsById(id);
    }

}
