package com.caribou.bank.repository;

import com.caribou.bank.domain.SavingsAccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the SavingsAccountTransaction entity.
 */
@Repository
public interface SavingsAccountTransactionRepository extends JpaRepository<SavingsAccountTransaction, Long> {
}
