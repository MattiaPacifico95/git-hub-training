package com.ictacademy.structureproject.controllers;

import com.ictacademy.structureproject.services.CardService;

import java.sql.SQLException;

public class CardController {

    CardService cardService = new CardService();


    public tipoDiRitorno verificaSaldoController(Long idUtente, Long idCatalogo, Long idTessera, List<ProdottoEntity> listaProdotti) throws SQLException {
        if(idUtente != null && idCatalogo != null && idTessera != null && listaProdotti != null){
          return cardService.verificaSaldo(idUtente, idCatalogo, idTessera, listaProdotti);
        }
    }
}
