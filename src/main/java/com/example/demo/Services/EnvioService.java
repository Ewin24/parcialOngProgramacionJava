package com.example.demo.Services;


import com.example.demo.Dtos.EnvioDTO;
import com.example.demo.Dtos.EnvioDTORefugioSedeCarga;

public interface EnvioService {
    
    EnvioDTO save(EnvioDTO envioDTOCargaRefugio);

    void deleteById(Long idEnvio);

    EnvioDTORefugioSedeCarga findById(Long idEnvio);
}