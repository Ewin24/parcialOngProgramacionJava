package com.example.demo.Configurations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Dtos.RefugioDTO;
import com.example.demo.Entities.RefugioEntity;

@Component
public class RefugioDTOConverter {
    @Autowired
    private ModelMapper dbm;

    public RefugioDTO convertToDTO(RefugioEntity refugioEntity) {
        return dbm.map(refugioEntity, RefugioDTO.class);
    }

    public RefugioEntity convertToEntity(RefugioDTO refugioDTO) {
        return dbm.map(refugioDTO, RefugioEntity.class);
    }

}