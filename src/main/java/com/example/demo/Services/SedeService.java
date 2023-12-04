package com.example.demo.Services;

import java.util.List;

import com.example.demo.Dtos.SedeDTO;

public interface SedeService {

    void save(SedeDTO sede);

    List<SedeDTO> findAll();

    void deleteById(Long idSede);

    SedeDTO findById(Long id);

    SedeDTO updateById(SedeDTO sedeDTO);

}
