package com.spring.fidelity.spring_fidelity.utils;

import com.spring.fidelity.spring_fidelity.dtos.ProdottoDto;
import com.spring.fidelity.spring_fidelity.entities.ProdottoEntity;

public class ProdottoConverter {

    public ProdottoDto toDto(ProdottoEntity prodottoEntity){
        ProdottoDto prodottoDto = new ProdottoDto();

        prodottoDto.setProdottoId(prodottoEntity.getIdProdotto());
        prodottoDto.setNomeProd(prodottoEntity.getNome());
        prodottoDto.setDescrizioneProd(prodottoEntity.getDescrizione());
        prodottoDto.setImmagineProd(prodottoEntity.getImmagine());
        prodottoDto.setPuntiProd(prodottoEntity.getPunti());
        prodottoDto.setFlagCancellazione(prodottoEntity.isFlagCancellato());
        return prodottoDto;
    }

    public ProdottoEntity toEntity(ProdottoDto prodottoDto){
        ProdottoEntity prodottoEntity = new ProdottoEntity();

        prodottoEntity.setIdProdotto(prodottoDto.getProdottoId());
        prodottoEntity.setNome(prodottoDto.getNomeProd());
        prodottoEntity.setDescrizione(prodottoDto.getDescrizioneProd());
        prodottoEntity.setImmagine(prodottoDto.getImmagineProd());
        prodottoEntity.setPunti(prodottoDto.getPuntiProd());
        prodottoEntity.setFlagCancellato(prodottoDto.isFlagCancellazione());
        return prodottoEntity;
    }

}
