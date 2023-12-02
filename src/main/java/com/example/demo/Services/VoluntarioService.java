package com.example.demo.Services;

import java.util.List;

import com.example.demo.Dtos.VoluntarioDTO;

public interface VoluntarioService {

    void save(VoluntarioDTO voluntarioDTO);

    List<VoluntarioDTO> findAll();

    VoluntarioDTO findById(Long idVoluntario);

    void deleteById(Long idVoluntario);

    VoluntarioDTO updateById(VoluntarioDTO voluntarioDTO);

    List<VoluntarioDTO> findVoluntarioBySede(Long idSede);

    List<VoluntarioDTO> findVoluntarioByProfesion(String profesion);

}