package com.example.demo.Dtos;

import lombok.Data;

@Data
public class SedeDTO {
    
    private Long id;
    private String ciudad;
    private String pais;
    private Long organizacionId;
    private Long voluntarioJefeId;

}

