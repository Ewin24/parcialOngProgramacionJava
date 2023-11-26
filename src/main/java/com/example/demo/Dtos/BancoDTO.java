package com.example.demo.Dtos;


import lombok.Data;

@Data
public class BancoDTO {
    
    private Long id;
    private Long socioId;
    private String nombreBanco;
    private String numeroCuenta;

}
