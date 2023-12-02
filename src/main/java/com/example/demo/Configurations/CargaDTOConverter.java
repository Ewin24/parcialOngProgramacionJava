package com.example.demo.Configurations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Dtos.CargaDTO;
import com.example.demo.Entities.CargaEntity;

@Component
public class CargaDTOConverter {

    @Autowired
    private ModelMapper dbm;

    public CargaDTO convertToDTO(CargaEntity cargaEntity) {
        return dbm.map(cargaEntity, CargaDTO.class);
    }

    public CargaEntity convertToEntity(CargaDTO cargaDTO) {
        return dbm.map(cargaDTO, CargaEntity.class);
    }

}