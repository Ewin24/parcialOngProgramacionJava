package com.example.demo.Configurations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Dtos.SedeDTO;
import com.example.demo.Entities.SedeEntity;

@Component
public class SedeDTOConverter {

    @Autowired
    private ModelMapper dbm;

    public SedeDTO convertToDTO(SedeEntity sede) {
        SedeDTO sedeDTO = dbm.map(sede, SedeDTO.class);
        if (sede.getVoluntarioJefe() != null) {
            sedeDTO.setVoluntarioJefeId(sede.getVoluntarioJefe().getId());
        }
        sedeDTO.setOrganizacionId(sede.getOrganizacion().getId());
        return sedeDTO;
    }

    public SedeEntity convertToEntity(SedeDTO sedeDTO) {
        return dbm.map(sedeDTO, SedeEntity.class);
    }

}
