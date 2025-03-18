package com.spring.fidelity.spring_fidelity.services;

import com.spring.fidelity.spring_fidelity.daos.tesseraDao;
import com.spring.fidelity.spring_fidelity.entities.TesseraEntity;
import com.spring.fidelity.spring_fidelity.entities.UserEntity;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TesseraService {
    public TesseraService() {
    }


//    UserDao userDao = new UserDao();
//    tesseraDao cardDao = new tesseraDao();
//    ProdottoDao prodottoDao = new ProdottoDao();
//    CatalogoDao catalogoDao = new CatalogoDao();

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
            //Da ricontrollare con CatalagoDao
            if(catalogo.getFineOfferta() < Timestamp.valueOf(LocalDateTime.now())){
                System.out.println("il catalogo non è più valido");
                return res;
            } else {
                int totalePunti = 0;
                for(ProdottoEntity prodotto : listaProdotti){
                    totalePunti = totalePunti + prodotto.getPunti();
                }
//              TesseraService card = tesseraDao.findById(idCard);

                TesseraEntity tessera = dao.findById(idCard);
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
