package com.example.demo.Services;
import java.util.List;

import com.example.demo.Dtos.BancoDTO;
import com.example.demo.Entities.BancoEntity;
import com.example.demo.Entities.SocioEntity;

public interface BancoService {
    
    void save(BancoDTO banco);

    List<BancoEntity> findBancosBySocio(SocioEntity socio);

}
