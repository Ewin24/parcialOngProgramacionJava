package com.example.demo.Services;

import java.util.List;

import com.example.demo.Dtos.EnvioDTO;
import com.example.demo.Dtos.EnvioDTORefugioSedeCarga;
import com.example.demo.Entities.EnvioEntity;

public interface EnvioService {

    EnvioDTO save(EnvioDTO envioDTOCargaRefugio);

    List<EnvioEntity> findAll();

    void deleteById(Long idEnvio);

    EnvioDTORefugioSedeCarga findById(Long idEnvio);
}