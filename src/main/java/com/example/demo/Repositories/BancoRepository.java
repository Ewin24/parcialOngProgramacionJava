package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entities.BancoEntity;
import com.example.demo.Entities.SocioEntity;

public interface BancoRepository extends CrudRepository<BancoEntity, Long> {
    List<BancoEntity> findBySocio(SocioEntity socio);
}
