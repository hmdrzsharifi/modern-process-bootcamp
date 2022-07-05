package com.caribou.bank.service.mapper;

import com.caribou.bank.domain.SavingsAccountTransaction;
import com.caribou.bank.service.dto.SavingsAccountTransactionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface SavingsAccountTransactionMapper {

    SavingsAccountTransactionDTO toDto(SavingsAccountTransaction savingsAccountTransaction);

    SavingsAccountTransaction toEntity(SavingsAccountTransactionDTO savingsAccountTransactionDTO);
}
