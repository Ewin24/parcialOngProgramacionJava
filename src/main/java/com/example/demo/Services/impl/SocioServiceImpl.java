package com.example.demo.Services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Configurations.*;
import com.example.demo.Dtos.BancoDTO;
import com.example.demo.Dtos.CuotaDTO;
import com.example.demo.Dtos.SocioCuotaDTO;
import com.example.demo.Dtos.SocioDTO;
import com.example.demo.Dtos.SocioDTOBancoCuota;
import com.example.demo.Entities.BancoEntity;
import com.example.demo.Entities.CuotaEntity;
import com.example.demo.Entities.SedeEntity;
import com.example.demo.Entities.SocioEntity;
import com.example.demo.Repositories.SedeRepository;
import com.example.demo.Repositories.SocioRepository;
import com.example.demo.Services.*;

import jakarta.transaction.Transactional;

@Service
public class SocioServiceImpl implements SocioService {

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private SocioDTOConverter socioDTOConverter;

    @Autowired
    private BancoDTOConverter bancoDTOConverter;

    @Autowired
    private CuotaDTOConverter cuotaDTOConverter;

    @Autowired
    private SocioDTOBancoCuotaConverter socioDTOBancoCuotaConverter;

    @Autowired
    private CuotaService cuotaService;

    @Autowired
    private BancoService bancoService;

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    @Transactional
    public void save(SocioDTO socioDTO, BancoDTO bancoDTO, CuotaDTO cuotaDTO) {
        SocioEntity socioEntity = socioDTOConverter.convertToEntity(socioDTO);
        if (socioEntity.getNombres() == null || socioEntity.getNombres().isEmpty()) {
            throw new IllegalArgumentException("El nombre del socio no puede ser nulo o vacío");
        }

        if (socioEntity.getApellidos() == null || socioEntity.getApellidos().isEmpty()) {
            throw new IllegalArgumentException("El apellido del socio no puede ser nulo o vacío");
        }

        if (socioEntity.getEmail() == null || socioEntity.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El email del socio no puede ser nulo o vacío");
        }

        if (socioEntity.getTelefono() == null || socioEntity.getTelefono().isEmpty()) {
            throw new IllegalArgumentException("El teléfono del socio no puede ser nulo o vacío");
        }
        SedeEntity sedeEntity = sedeRepository.findById(socioDTO.getSedeId()).orElse(null);
        System.out.println("Sede es " + sedeEntity.getPais());
        socioEntity.setSede(sedeEntity);
        SocioEntity socioGuardado = socioRepository.save(socioEntity);
        cuotaDTO.setSocioId(socioGuardado.getId());
        bancoDTO.setSocioId(socioGuardado.getId());
        cuotaService.save(cuotaDTO);
        bancoService.save(bancoDTO);
    }

    @Override
    public List<SocioDTOBancoCuota> findAll() {
        List<SocioEntity> socioEntities = (List<SocioEntity>) socioRepository.findAll();

        return socioEntities.stream().map(socioEntity -> {
            SocioDTOBancoCuota socioDTOBancoCuota = socioDTOBancoCuotaConverter.convertToDTO(socioEntity);
            List<BancoEntity> bancoEntities = bancoService.findBancosBySocio(socioEntity);
            List<BancoDTO> bancosDTO = bancoEntities.stream()
                    .map(bancoEntity -> {
                        return bancoDTOConverter.convertToDTO(bancoEntity);
                    }).collect(Collectors.toList());
            socioDTOBancoCuota.setBancos(bancosDTO);

            List<CuotaEntity> cuotaEntities = cuotaService.findCuotasBySocio(socioEntity);
            List<CuotaDTO> cuotasDTO = cuotaEntities.stream()
                    .map(cuotaEntity -> {
                        return cuotaDTOConverter.convertToDTO(cuotaEntity);
                    }).collect(Collectors.toList());
            socioDTOBancoCuota.setCuotas(cuotasDTO);

            return socioDTOBancoCuota;
        }).collect(Collectors.toList());
    }

    @Override
    public SocioCuotaDTO findSociosByCuota(String tipoCuota) {
        SocioCuotaDTO socioCuotaDTO = new SocioCuotaDTO();
        socioCuotaDTO.setTipoCuota(tipoCuota);
        List<SocioDTO> sociosDTO = socioRepository.findSociosByTipoCuota(tipoCuota).stream()
                .map(socioEntity -> {
                    return socioDTOConverter.convertToDTO(socioEntity);
                }).collect(Collectors.toList());
        socioCuotaDTO.setSocios(sociosDTO);
        return socioCuotaDTO;
    }

}
