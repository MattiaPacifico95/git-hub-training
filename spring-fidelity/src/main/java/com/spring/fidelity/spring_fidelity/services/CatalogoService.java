package com.spring.fidelity.spring_fidelity.services;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.spring.fidelity.spring_fidelity.daos.CatalogoDao;
import com.spring.fidelity.spring_fidelity.daos.ProdottoDao;
import com.spring.fidelity.spring_fidelity.entities.CatalogoEntity;
import com.spring.fidelity.spring_fidelity.entities.ProdottoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class CatalogoService {
    private final ProdottoDao prodottoDao;
    private CatalogoDao catDao;
    private CatalogoEntity catalogo;

    public CatalogoService (CatalogoDao catDao, ProdottoDao prodottoDao) {
        this.catDao = catDao;
        this.prodottoDao = prodottoDao;
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

    public List<ProdottoEntity> findProdottiInCatalogo (Long idCatalogo) {
        List<ProdottoEntity> listaProdotti = new ArrayList<ProdottoEntity>();
        List<Long> lIdProd = catDao.listProdInCat(idCatalogo);
        for(Long idProdotto : lIdProd){
            ProdottoEntity prod = prodottoDao.findByID(idCatalogo);
            listaProdotti.add(prod);
        }
        return listaProdotti;
    }

    public void aggiungiProdottoInCatalogo (Long idProdotto, Long idCatalogo) {
        ProdottoEntity prod = prodottoDao.findByID(idProdotto);
        CatalogoEntity cat = catDao.findByID(idCatalogo);
        cat.getProdottiCatalogo().add(prod);
        catDao.save(cat);
    }



}
