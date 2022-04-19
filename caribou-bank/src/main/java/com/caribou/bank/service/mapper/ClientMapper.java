package com.caribou.bank.service.mapper;


import com.caribou.bank.domain.Client;
import com.caribou.bank.service.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link Client} and its DTO {@link ClientDTO}.
 */
@Mapper(componentModel = "spring", uses = {OfficeMapper.class})
public interface ClientMapper {

    @Mapping(source = "office.id", target = "officeId")
    ClientDTO toDto(Client client);

    @Mapping(source = "officeId", target = "office")
    Client toEntity(ClientDTO clientDTO);

    default Client fromId(Long id) {
        if (id == null) {
            return null;
        }
        Client client = new Client();
        client.setId(id);
        return client;
    }
}
