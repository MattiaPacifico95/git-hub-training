package com.spring.fidelity.spring_fidelity.services;

import com.spring.fidelity.spring_fidelity.daos.ProdottoDao;
import com.spring.fidelity.spring_fidelity.daos.UserDao;
import com.spring.fidelity.spring_fidelity.entities.ProdottoEntity;
import com.spring.fidelity.spring_fidelity.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ProdottoService {

    private ProdottoEntity prodotto;

    ProdottoDao prodottoDao;
    UserDao userDao;

    public void rimuoviProdotto (ProdottoEntity prodotto) {
        prodotto.setFlagCancellato(true);
    }

    public boolean modificaPunti(Long idUtente, ProdottoEntity prodotto) throws SQLException {

        boolean res = false;
        UserEntity user = userDao.findBy(idUtente);
        if(user.getIdRuolo() == 1){
            System.out.println("l'utente non ha il ruolo necessario per compiere la richiesta");
            return res;
        } else {
            prodottoDao.updateProdotto(prodotto.getNome(),prodotto.getDescrizione(), prodotto.getPunti(), prodotto.getDataCreazione());
            res = true;
            return res;
        }
    }
}
