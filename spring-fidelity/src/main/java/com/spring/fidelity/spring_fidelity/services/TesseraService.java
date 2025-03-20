package com.spring.fidelity.spring_fidelity.services;

import com.spring.fidelity.spring_fidelity.daos.CatalogoDao;
import com.spring.fidelity.spring_fidelity.daos.UserDao;
import com.spring.fidelity.spring_fidelity.daos.tesseraDao;
import com.spring.fidelity.spring_fidelity.model.entities.CatalogoEntity;
import com.spring.fidelity.spring_fidelity.model.entities.ProdottoEntity;
import com.spring.fidelity.spring_fidelity.model.entities.TesseraEntity;
import com.spring.fidelity.spring_fidelity.model.entities.UserEntity;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class TesseraService {
    public TesseraService() {
    }


    UserDao userDao;
    UserEntity user;
    tesseraDao tesseraDao;
//    ProdottoDao prodottoDao
    CatalogoDao catalogoDao;

    //verifica che il saldo punti sia >= al totale dei prodotti
    // selezionati
    public boolean verificaSaldo(Long idUser, Long idCard, Long idCatalogo, List<ProdottoEntity> listaProdotti) throws SQLException {

        boolean res=false;
        //Cerchiamo l'utente usando l'idUser e il dao dello user
        user = userDao.findBy(idUser);
        //Se l'utente ha ruolo responsabile esci
        if(user.getIdRuolo() !=  3) {
            System.out.println("l'utente non ha il ruolo corretto");
            return res;
        } else {

            CatalogoEntity catalogo = catalogoDao.findByID(idCatalogo);
            //Da ricontrollare con CatalagoDao
            LocalDateTime oggi = LocalDateTime.now();
            Timestamp controlloData = catalogo.getFineOfferta();
            LocalDateTime controlloDataF = controlloData.toLocalDateTime();
            if(oggi.isAfter(controlloDataF)){
                System.out.println("il catalogo non è più valido");
                return res;
            } else {
                int totalePunti = 0;
                for(ProdottoEntity prodotto : listaProdotti){
                    totalePunti = totalePunti + prodotto.getPunti();
                }
//              TesseraService card = tesseraDao.findById(idCard);

                TesseraEntity tessera = tesseraDao.findByID(idCard);
                if(tessera.getSaldoPunti() < totalePunti){
                    System.out.println("non hai abbastanza punti");
                    return res;
                } else {
                    res = true;
                    System.out.println("Hai "+tessera.getSaldoPunti()+" e i prodotti che vuoi prendere costano"+totalePunti);
                    return res;
                }
            }
        }

    }
}
