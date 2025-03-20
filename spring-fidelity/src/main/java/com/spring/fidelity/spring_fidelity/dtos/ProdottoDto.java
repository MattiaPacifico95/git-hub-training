package com.spring.fidelity.spring_fidelity.dtos;

import lombok.Data;

import java.security.Timestamp;

@Data
public class ProdottoDto {

    public long prodottoId;
    public String nomeProd;
    public String descrizioneProd;
    public String immagineProd;
    public int PuntiProd;
    public boolean FlagCancellazione;

}
