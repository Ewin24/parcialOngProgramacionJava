package com.example.demo.Dtos;

import java.util.List;

import lombok.Data;

@Data
public class EnvioDTO {

    private Long id;
    private String fechaSalida;
    private Long idRefugio;
    private List<CargaDTO> cargas;
    private List<Long> sedes;

}