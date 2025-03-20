package com.spring.fidelity.spring_fidelity.dtos;

import lombok.Data;

import java.security.Timestamp;

@Data
public class ProdottoDto {
    private String nome;
    private String descrizione;
    private int Punti;
    //private Timestamp DataCreazione;
}
