package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entities.SedeEntity;
import com.example.demo.Entities.SocioEntity;

public interface SocioRepository extends CrudRepository<SocioEntity, Long>{

    List<SocioEntity> findBySede(SedeEntity sede);

    @Query(value = "SELECT s.* FROM socio s JOIN cuota c ON s.id = c.id_socio WHERE c.tipo_cuota = ?1", nativeQuery = true)
    List<SocioEntity> findSociosByTipoCuota(String tipoCuota);
}
