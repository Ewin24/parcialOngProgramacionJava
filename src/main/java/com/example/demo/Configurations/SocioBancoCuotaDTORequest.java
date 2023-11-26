package com.example.demo.Configurations;

import com.example.demo.Dtos.BancoDTO;
import com.example.demo.Dtos.CuotaDTO;
import com.example.demo.Dtos.SocioDTO;

import lombok.Data;

@Data
public class SocioBancoCuotaDTORequest {

    private SocioDTO socioDTO;
    private BancoDTO bancoDTO;
    private CuotaDTO cuotaDTO;

}
