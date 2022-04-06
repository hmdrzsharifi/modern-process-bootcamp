package com.caribou.bank.repository;

import com.caribou.bank.domain.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the Office entity.
 */
@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
}
