package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entities.CuotaEntity;
import com.example.demo.Entities.SocioEntity;

public interface CuotaRepository extends CrudRepository<CuotaEntity, Long>{
    List<CuotaEntity> findBySocio(SocioEntity socio);
}
