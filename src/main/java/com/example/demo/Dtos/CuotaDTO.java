package com.example.demo.Dtos;

import lombok.Data;

@Data
public class CuotaDTO {

    private Long id;
    private Long socioId;
    private String fechaPago;
    private String tipoCuota;

}
