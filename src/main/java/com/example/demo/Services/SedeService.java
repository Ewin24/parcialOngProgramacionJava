package com.example.demo.Services;

import java.util.List;

import com.example.demo.Dtos.SedeDTO;
import com.example.demo.Entities.SedeEntity;

public interface SedeService {

    void save(SedeDTO sede);

    List<SedeDTO> findAll();

    void deleteById(Long idSede);

    SedeEntity findById(Long id);

    SedeEntity updateById(SedeDTO sedeDTO);
    
}
