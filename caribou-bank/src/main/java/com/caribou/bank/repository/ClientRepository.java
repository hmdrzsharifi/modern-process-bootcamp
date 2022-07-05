package com.caribou.bank.repository;

import com.caribou.bank.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the Client entity.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
