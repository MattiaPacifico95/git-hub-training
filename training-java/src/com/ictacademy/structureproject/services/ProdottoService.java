package com.ictacademy.structureproject.services;
import com.ictacademy.structureproject.daos.*;
import com.ictacademy.structureproject.entities.ProdottoEntity;
import com.ictacademy.structureproject.entities.UserEntity;
import com.ictacademy.structureproject.utils.DbConnection;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ProdottoService {
    ProdottoDao prodottoDao = new ProdottoDao();
    CatalogoDao catalogoDao = new CatalogoDao();
    CatalogoProdottoDao catalogoProdottoDao = new CatalogoProdottoDao();

    List<ProdottoEntity> listaProdotti = new ArrayList<>();

    public List<ProdottoEntity> aggiungiProdotto(long idProdotto) throws SQLException {


        ProdottoEntity prodottoEsistente = prodottoDao.findById(idProdotto);

        if (prodottoEsistente != null && prodottoEsistente.getIdProdotto() > 0) {
            listaProdotti.add(prodottoEsistente);
        } else {
            System.out.println("Prodotto con ID " + idProdotto + " non trovato.");
        }

        return listaProdotti;
    }


    public List<ProdottoEntity> cancellaProdotto(long idProdotto) throws SQLException {

        ProdottoEntity prodottoDaCancellare = null;
        for (ProdottoEntity prodotto : listaProdotti) {
            if (prodotto.getIdProdotto() == idProdotto) {
                prodottoDaCancellare = prodotto;
                break;
            }
        }

        if (prodottoDaCancellare != null) {
            listaProdotti.remove(prodottoDaCancellare);
        } else {
            System.out.println("Prodotto con ID " + idProdotto + " non trovato nella lista.");
        }

        return listaProdotti;
    }
}