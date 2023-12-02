package com.example.demo.Configurations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Dtos.EnvioDTO;
import com.example.demo.Dtos.EnvioDTORefugioSedeCarga;
import com.example.demo.Entities.EnvioEntity;

@Component
public class EnvioDTOConverter {
    @Autowired
    private ModelMapper dbm;

    public EnvioDTO convertToDTO(EnvioEntity envioEntity) {
        return dbm.map(envioEntity, EnvioDTO.class);
    }

    public EnvioDTORefugioSedeCarga convertToDTOFull(EnvioEntity envioEntity) {
        return dbm.map(envioEntity, EnvioDTORefugioSedeCarga.class);
    }

    public EnvioEntity convertToEntity(EnvioDTO envioDTO) {
        return dbm.map(envioDTO, EnvioEntity.class);
    }

}