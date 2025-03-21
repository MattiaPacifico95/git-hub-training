package com.spring.fidelity.spring_fidelity.utils;

import com.spring.fidelity.spring_fidelity.dtos.tesseraDto;
import com.spring.fidelity.spring_fidelity.entities.TesseraEntity;

public class tesseraConverter{
    public TesseraEntity toTesseraDto (tesseraDto dto){
        TesseraEntity v= new TesseraEntity();
        v.setIdTessera(dto.getTesseraId());
        v.setIdUtente(dto.getUtenteId());
        v.setSaldoPunti(dto.getTesseraPunti());
        v.setFlagCancellato(dto.isCancellazione());
        return v;
    }

    public tesseraDto toTesseraEntity(TesseraEntity Entity) {
        tesseraDto v = new tesseraDto();
        v.setTesseraId(Entity.getIdTessera());
        v.setTesseraPunti(Entity.getSaldoPunti());
        v.setUtenteId(Entity.getIdUtente());
        v.setCancellazione(Entity.isFlagCancellato());
        return v;
    }



}
