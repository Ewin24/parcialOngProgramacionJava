package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Configurations.SocioBancoCuotaDTORequest;
import com.example.demo.Dtos.SocioCuotaDTO;
import com.example.demo.Dtos.SocioDTO;
import com.example.demo.Dtos.SocioDTOBancoCuota;
import com.example.demo.Services.SocioService;

public class SocioController {

    @Autowired
    private SocioService socioService;

    @GetMapping("/")
    public List<SocioDTOBancoCuota> findAll() {
        return socioService.findAll();
    }

    @GetMapping("/id/{idSocio}")
    public SocioDTO findSocioById(@PathVariable Long idSocio) {
        return socioService.findById(idSocio);
    }

    @GetMapping("/cuota/{tipoCuota}")
    public SocioCuotaDTO findSociosByCuota(@PathVariable String tipoCuota) {
        return socioService.findSociosByCuota(tipoCuota);
    }

    @PostMapping("/")
    public void save(@RequestBody SocioBancoCuotaDTORequest request) {
        socioService.save(request.getSocioDTO(), request.getBancoDTO(), request.getCuotaDTO());
    }

    @DeleteMapping("/id/{idSocio}")
    public void deleteSocioById(@PathVariable Long idSocio) {
        socioService.deleteById(idSocio);
    }

    @PutMapping("/id/{idSocio}")
    public ResponseEntity<SocioDTO> actualizarSede(@PathVariable Long idSocio, @RequestBody SocioDTO socioDTO) {
        socioDTO.setId(idSocio); // asegurar que el ID del DTO sea el mismo que el de la ruta
        SocioDTO socioActualizado = socioService.updateById(socioDTO);
        return ResponseEntity.ok(socioActualizado);
    }
}