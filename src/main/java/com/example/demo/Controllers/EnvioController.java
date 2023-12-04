package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dtos.EnvioDTO;
import com.example.demo.Dtos.EnvioDTORefugioSedeCarga;
import com.example.demo.Entities.EnvioEntity;
import com.example.demo.Repositories.EnvioRepository;
import com.example.demo.Services.EnvioService;

@RestController
@RequestMapping("/envio")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @Autowired
    private EnvioRepository envioRepository;

    @GetMapping("/")
    public List<EnvioEntity> findAll() {
        
        return (List<EnvioEntity>) envioRepository.findAll();
    }

    @GetMapping("/id/{idEnvio}")
    public EnvioDTORefugioSedeCarga findEnvioById(@PathVariable Long idEnvio) {
        return envioService.findById(idEnvio);
    }

    @PostMapping("/")
    public EnvioDTO save(@RequestBody EnvioDTO envioDTO) {
        return envioService.save(envioDTO);
    }

}