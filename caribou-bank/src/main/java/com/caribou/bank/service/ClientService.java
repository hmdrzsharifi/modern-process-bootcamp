package com.caribou.bank.service;


import com.caribou.bank.domain.Client;
import com.caribou.bank.repository.ClientRepository;
import com.caribou.bank.service.dto.ClientDTO;
import com.caribou.bank.service.mapper.ClientMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Client}.
 */
@Service
public class ClientService {

    private final Logger log = LoggerFactory.getLogger(ClientService.class);

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    /**
     * Save a client.
     *
     * @param clientDTO the entity to save.
     * @return the persisted entity.
     */
    public ClientDTO save(ClientDTO clientDTO) {
        log.debug("Request to save Client : {}", clientDTO);
        Client client = clientMapper.toEntity(clientDTO);
        client = clientRepository.save(client);
        return clientMapper.toDto(client);
    }

    /**
     * Update a client.
     *
     * @param clientDTO the entity to update.
     * @return the updated entity.
     */
    public ClientDTO update(ClientDTO clientDTO) {
        log.debug("Request to update office: {}", clientDTO);
        Client client = clientMapper.toEntity(clientDTO);
        client = clientRepository.save(client);
        return clientMapper.toDto(client);
    }

    /**
     * Get all the clients.
     *
     * @return the list of entities.
     */
    public List<ClientDTO> findAll() {
        log.debug("Request to get all Clients");
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one client by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<ClientDTO> findOne(Long id) {
        log.debug("Request to get Client : {}", id);
        return clientRepository.findById(id)
                .map(clientMapper::toDto);
    }

    /**
     * Delete the client by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Client : {}", id);
        clientRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return clientRepository.existsById(id);
    }
}
