package com.caribou.bank.service.mapper;

import com.caribou.bank.domain.SavingsAccount;
import com.caribou.bank.service.dto.SavingsAccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link SavingsAccount} and its DTO {@link SavingsAccountDTO}.
 */
@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface SavingsAccountMapper {

    @Mapping(source = "client.id", target = "clientId")
    SavingsAccountDTO toDto(SavingsAccount savingsAccount);

    @Mapping(source = "clientId", target = "client")
    SavingsAccount toEntity(SavingsAccountDTO savingsAccountDTO);

    default SavingsAccount fromId(Long id) {
        if (id == null) {
            return null;
        }
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setId(id);
        return savingsAccount;
    }
}
