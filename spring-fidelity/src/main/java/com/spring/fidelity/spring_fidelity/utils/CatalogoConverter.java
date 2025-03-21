package com.spring.fidelity.spring_fidelity.utils;

import com.spring.fidelity.spring_fidelity.dtos.CatalogoDto;
import com.spring.fidelity.spring_fidelity.entities.CatalogoEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class CatalogoConverter {


    public CatalogoDto toDto (CatalogoEntity catalogoEntity){

        CatalogoDto catDto = new CatalogoDto();

        catDto.setCatID(catalogoEntity.getIdCatalogo());
        catDto.setTrueName(catalogoEntity.getNome());
        catDto.setEndOffer(catalogoEntity.getFineOfferta());
        catDto.setFlagCancelled(catalogoEntity.isFlagCancellato());

        return catDto;
    }

    public CatalogoEntity toEntity (CatalogoDto catalogoDto){

        CatalogoEntity catEntity = new CatalogoEntity();


        catEntity.setIdCatalogo(catalogoDto.getCatID());
        catEntity.setNome(catalogoDto.getTrueName());
        catEntity.setFineOfferta(catalogoDto.getEndOffer());
        catEntity.setFlagCancellato(catalogoDto.isFlagCancelled());

        return catEntity;
    }

}
