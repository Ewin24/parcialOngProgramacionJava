package com.example.demo.Repositories;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entities.RefugioEntity;

public interface RefugioRepository extends CrudRepository<RefugioEntity, Long>{
    
}
