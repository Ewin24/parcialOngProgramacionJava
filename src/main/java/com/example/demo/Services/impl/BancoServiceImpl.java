package com.example.demo.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Configurations.BancoDTOConverter;
import com.example.demo.Dtos.BancoDTO;
import com.example.demo.Entities.BancoEntity;
import com.example.demo.Entities.SocioEntity;
import com.example.demo.Repositories.BancoRepository;
import com.example.demo.Repositories.SocioRepository;
import com.example.demo.Services.BancoService;

@Service
public class BancoServiceImpl implements BancoService {

    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private BancoDTOConverter bancoDTOConverter;

    @Override
    public void save(BancoDTO bancoDTO) {
        BancoEntity bancoEntity = bancoDTOConverter.convertToEntity(bancoDTO);
        if (bancoEntity.getNombreBanco() == null || bancoEntity.getNombreBanco().isEmpty()) {
            throw new IllegalArgumentException("El nombre del banco no puede ser nulo o vacío");
        }
        SocioEntity socioEntity = socioRepository.findById(bancoDTO.getSocioId()).orElse(null);
        bancoEntity.setSocio(socioEntity);
        bancoRepository.save(bancoEntity);
    }

    @Override
    public List<BancoEntity> findBancosBySocio(SocioEntity socio) {
        List<BancoEntity> bancos = bancoRepository.findBySocio(socio);
        return bancos;
    }

}
