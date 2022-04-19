package com.caribou.bank.service.mapper;

import com.caribou.bank.domain.SavingsAccountTransaction;
import com.caribou.bank.service.dto.SavingsAccountTransactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link SavingsAccountTransaction} and its DTO {@link SavingsAccountTransactionDTO}.
 */
@Mapper(componentModel = "spring", uses = {SavingsAccountMapper.class})
public interface SavingsAccountTransactionMapper {

//    @Mapping(source = "savingsAccount.id", target = "savingsAccountId")
    SavingsAccountTransactionDTO toDto(SavingsAccountTransaction savingsAccountTransaction);

//    @Mapping(source = "savingsAccountId", target = "savingsAccount")
    SavingsAccountTransaction toEntity(SavingsAccountTransactionDTO savingsAccountTransactionDTO);

    default SavingsAccountTransaction fromId(Long id) {
        if (id == null) {
            return null;
        }
        SavingsAccountTransaction savingsAccountTransaction = new SavingsAccountTransaction();
        savingsAccountTransaction.setId(id);
        return savingsAccountTransaction;
    }
}
