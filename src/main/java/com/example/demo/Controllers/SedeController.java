package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dtos.SedeDTO;
import com.example.demo.Services.SedeService;

@RestController
@RequestMapping("/sede")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @GetMapping("/")
    public List<SedeDTO> findAll(){
        return sedeService.findAll();
    }

    @GetMapping("/{idSede}")
    public SedeDTO findById(@PathVariable Long idSede){
        return sedeService.findById(idSede);        
    }

    @PostMapping("/")
    public void save(@RequestBody SedeDTO sedeDTO){
        sedeService.save(sedeDTO);
    }

    @DeleteMapping("/{idSede}")
    public void deleteById(@PathVariable Long idSede) throws NotFoundException{
        sedeService.deleteById(idSede);        
    }

    @PutMapping("/{idSede}")
    public ResponseEntity<SedeDTO> actualizarSede(@PathVariable Long idSede, @RequestBody SedeDTO sedeDTO) {
        sedeDTO.setId(idSede); // asegurar que el ID del DTO sea el mismo que el de la ruta
        SedeDTO sedeActualizada = sedeService.updateById(sedeDTO);
        return ResponseEntity.ok(sedeActualizada);
    }
    
}