package com.caribou.bank.service.mapper;

import com.caribou.bank.domain.Office;
import com.caribou.bank.service.dto.OfficeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link Office} and its DTO {@link OfficeDTO}
 */
@Mapper(componentModel = "spring", uses = {})
public interface OfficeMapper {

    @Mapping(source = "parent.id", target = "parentId")
    OfficeDTO toDto(Office office);

    @Mapping(source = "parentId", target = "parent")
    Office toEntity(OfficeDTO officeDTO);

    default Office fromId(Long id) {
        if (id == null){
            return null;
        }
        Office office = new Office();
        office.setId(id);
        return office;

    }
}
