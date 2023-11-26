package com.example.demo.Dtos;


import lombok.Data;

@Data
public class SocioDTO {
    
    private Long id;
    private String dni;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String email;
    private Long sedeId;

}
