package com.example.demo.Services;

import java.util.List;

import com.example.demo.Dtos.BancoDTO;
import com.example.demo.Dtos.CuotaDTO;
import com.example.demo.Dtos.SocioCuotaDTO;
import com.example.demo.Dtos.SocioDTO;
import com.example.demo.Dtos.SocioDTOBancoCuota;

public interface SocioService {

    void save(SocioDTO socio, BancoDTO banco, CuotaDTO cuota);

    List<SocioDTOBancoCuota> findAll();

    SocioCuotaDTO findSociosByCuota(String tipoCuota);

    SocioDTO findById(Long idSocio);

    void deleteById(Long idSocio);

    SocioDTO updateById(SocioDTO socioDTO);
}
