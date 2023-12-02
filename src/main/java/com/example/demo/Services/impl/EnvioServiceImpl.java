package com.example.demo.Services.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Configurations.CargaDTOConverter;
import com.example.demo.Configurations.EnvioDTOConverter;
import com.example.demo.Dtos.CargaDTO;
import com.example.demo.Dtos.EnvioDTO;
import com.example.demo.Dtos.EnvioDTORefugioSedeCarga;
import com.example.demo.Entities.CargaEntity;
import com.example.demo.Entities.EnvioEntity;
import com.example.demo.Entities.RefugioEntity;
import com.example.demo.Entities.SedeEntity;
import com.example.demo.Repositories.CargaRepository;
import com.example.demo.Repositories.EnvioRepository;
import com.example.demo.Repositories.RefugioRepository;
import com.example.demo.Repositories.SedeRepository;
import com.example.demo.Services.EnvioService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EnvioServiceImpl implements EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    @Autowired
    private RefugioRepository refugioRepository;

    @Autowired
    private CargaRepository cargaRepository;

    @Autowired
    private SedeRepository sedeRepository;

    @Autowired
    private EnvioDTOConverter envioDTOConverter;

    @Autowired
    private CargaDTOConverter cargaDTOConverter;

    @Override
    @Transactional
    public EnvioDTO save(EnvioDTO envioDTO) {
        EnvioEntity envioEntity = envioDTOConverter.convertToEntity(envioDTO);

        if (envioEntity.getFechaSalida() == null) {
            throw new IllegalArgumentException("La fecha no puede ser nulo o vacío");
        }

        if (envioDTO.getIdRefugio() != null) {
            RefugioEntity refugioEntity = refugioRepository.findById(envioDTO.getIdRefugio())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Refugio no encontrado con ID: " + envioDTO.getIdRefugio()));
            envioEntity.setRefugio(refugioEntity);
        }

        if (envioDTO.getSedes() != null && !envioDTO.getSedes().isEmpty()) {
            for (Long sedeId : envioDTO.getSedes()) {
                SedeEntity sedeEntity = sedeRepository.findById(sedeId)
                        .orElseThrow(() -> new EntityNotFoundException("Sede no encontrada con ID: " + sedeId));
                envioEntity.getSedes().add(sedeEntity);
            }
        }

        EnvioEntity envioGuardado = envioRepository.save(envioEntity);

        List<CargaEntity> cargaEntities = new ArrayList<>();
        if (envioDTO.getCargas() != null) {
            int i = 0;
            for (CargaDTO cargaDTO : envioDTO.getCargas()) {
                CargaEntity cargaEntity = cargaDTOConverter.convertToEntity(cargaDTO);
                cargaEntity.setEnvio(envioGuardado); // Asocia la carga con el envío
                cargaEntities.add(cargaEntity);
                envioDTO.getCargas().get(i).setIdEnvio(envioGuardado.getId());
                i++;
            }
        }

        cargaRepository.saveAll(cargaEntities);
        envioDTO.setId(envioGuardado.getId());
        return envioDTO;
    }

    @Override
    public void deleteById(Long idEnvio) {
        envioRepository.deleteById(idEnvio);
    }

    @Override
    public EnvioDTORefugioSedeCarga findById(Long idEnvio) {
        EnvioEntity envioEntity = envioRepository.findById(idEnvio).orElse(null);
        if (envioEntity != null) {
            EnvioDTORefugioSedeCarga envioDTORefugioSedeCarga = envioDTOConverter.convertToDTOFull(envioEntity);
            List<Long> sedes = envioRepository.findSedesByIdEnvio(envioDTORefugioSedeCarga.getId());
            if (!sedes.isEmpty()) {
                envioDTORefugioSedeCarga.setSedes(sedes);
            }
            return envioDTORefugioSedeCarga;
        }
        return null;
    }
}