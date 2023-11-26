package com.example.demo.Dtos;

import java.util.List;

import lombok.Data;

@Data
public class SocioCuotaDTO {
    
    private String tipoCuota;
    private List<SocioDTO> socios;

}
