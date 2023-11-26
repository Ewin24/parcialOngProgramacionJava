package com.example.demo.Services;

import java.util.List;

import com.example.demo.Dtos.CuotaDTO;
import com.example.demo.Entities.CuotaEntity;
import com.example.demo.Entities.SocioEntity;

public interface CuotaService {
    void save(CuotaDTO cuota);

    List<CuotaEntity> findCuotasBySocio(SocioEntity socio);

}
