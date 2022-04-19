package com.caribou.bank.repository;

import com.caribou.bank.domain.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the SavingsAccount entity.
 */
@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
}
