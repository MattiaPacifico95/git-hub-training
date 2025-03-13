package com.ictacademy.structureproject.services;

import com.ictacademy.structureproject.daos.CardDao;
import com.ictacademy.structureproject.daos.UserDao;
import com.ictacademy.structureproject.entities.CardEntity;
import com.ictacademy.structureproject.entities.UserEntity;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CardService {

    public CardService() {}

    UserDao userDao = new UserDao();
    CardDao cardDao = new CardDao();
    ProdottoDao prodottoDao = new ProdottoDao();
    CatalogoDao catalogoDao = new CatalogoDao();

    //verifica che il saldo punti sia >= al totale dei prodotti
    // selezionati
    public boolean verificaSaldo(Long idUser, Long idCard, Long idCatalogo, List<ProdottoEntity> listaProdotti) throws SQLException {

        boolean res=false;

        UserEntity user = userDao.findById(idUser);
        if(user.getIdRuolo() !=  1) {
            System.out.println("l'utente non ha il ruolo corretto");
            return res;
        } else {
            CatalogoEntity catalogo = catalogoDao.findById(idCatalogo);
            if(catalogo.getFineOfferta()< Timestamp.valueOf(LocalDateTime.now())){
                System.out.println("il catalogo non è più valido");
                return res;
            } else {
                int totalePunti = 0;
                for(ProdottoEntity prodotto : listaProdotti){
                    totalePunti = totalePunti + prodotto.getPunti();
                }
                CardEntity card = cardDao.findById(idCard);
                if(card.getSaldoPunti() < totalePunti){
                    System.out.println("non hai abbastanza punti");
                    return res;
                } else {
                    res = true;
                    System.out.println("hai"+card.getSaldoPunti()+"è i prodotti che vuoi prendere costano"+totalePunti);
                    return res;
                }
            }
        }

    }
}
