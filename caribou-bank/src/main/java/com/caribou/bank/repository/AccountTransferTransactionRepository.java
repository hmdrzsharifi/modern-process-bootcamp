package com.caribou.bank.repository;

import com.caribou.bank.domain.AccountTransferTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransferTransactionRepository extends JpaRepository<AccountTransferTransaction, Long> {

}
