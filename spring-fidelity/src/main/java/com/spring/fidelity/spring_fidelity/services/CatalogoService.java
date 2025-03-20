package com.spring.fidelity.spring_fidelity.services;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.spring.fidelity.spring_fidelity.daos.CatalogoDao;
import com.spring.fidelity.spring_fidelity.model.entities.CatalogoEntity;
import org.springframework.stereotype.Service;

@Service
public class CatalogoService {
    private CatalogoDao catDao;
    private CatalogoEntity catalogo;

    public CatalogoService (CatalogoDao catDao) {
        this.catDao = catDao;
    }


    public void concludiCatalogo () throws SQLException {
        LocalDateTime oggi = LocalDateTime.now();
        Timestamp controlloData = catalogo.getFineOfferta();
        LocalDateTime controlloDataF = controlloData.toLocalDateTime();
        if (oggi.isAfter(controlloDataF)){
            catalogo.setFlagCancellato(true);
        }
    }

    public void setFineOfferta (Timestamp fineOfferta) {
        catalogo.setFineOfferta(fineOfferta);
        catDao.save(catalogo);
    }

    public void emergencyFlag (CatalogoEntity catalogo) {
        this.catalogo.setFlagCancellato(true);

    }



}
