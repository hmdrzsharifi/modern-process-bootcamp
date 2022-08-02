package com.modern.process.repository;

import com.modern.process.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Modifying
    @Query(value = "UPDATE account SET amount= :amount WHERE id= :id", nativeQuery = true)
    void changeAmount(@Param("id") long id, @Param("amount") BigDecimal amount);
}
