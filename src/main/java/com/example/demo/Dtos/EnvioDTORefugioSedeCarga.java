package com.example.demo.Dtos;

import java.util.List;

import lombok.Data;

@Data
public class EnvioDTORefugioSedeCarga {

    private Long id;
    private String fechaSalida;
    private RefugioDTO refugio;
    private List<CargaDTO> cargas;
    private List<Long> sedes;

}