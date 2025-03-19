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
    UserDao userDao = new UserDao();



    //modifica punti prodotto
    public boolean modificaPunti(Long idUtente, ProdottoEntity prodotto) throws SQLException {

        boolean res = false;
        UserEntity user = userDao.findById(idUtente);
        if(user.getIdRuolo() == 1){
            System.out.println("l'utente non ha il tuolo necessario per compiere la richiesta");
            return res;
        } else {
            res = prodottoDao.updateProdotto(prodotto.getNome(),prodotto.getDescrizione(), prodotto.getPunti(), prodotto.getdataCreazione());
            return res;
        }
    }


    public List<ProdottoEntity> cancellaProdotto(long idProdotto) throws SQLException {

        List<ProdottoEntity> listaProdotti = new ArrayList<>();
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