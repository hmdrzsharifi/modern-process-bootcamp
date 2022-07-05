package com.caribou.bank.service.mapper;

import com.caribou.bank.domain.AccountTransferTransaction;
import com.caribou.bank.domain.SavingsAccountTransaction;
import com.caribou.bank.service.dto.AccountTransferTransactionDTO;
import com.caribou.bank.service.dto.SavingsAccountTransactionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface AccountTransferTransactionMapper {

    AccountTransferTransactionDTO toDto(AccountTransferTransaction accountTransferTransaction);

    AccountTransferTransaction toEntity(AccountTransferTransactionDTO accountTransferTransactionDTO);
}
