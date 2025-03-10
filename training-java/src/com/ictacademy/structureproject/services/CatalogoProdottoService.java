package com.ictacademy.structureproject.services;

import com.ictacademy.structureproject.entities.CatalogoEntity;
//import com.ictacademy.structureproject.entities.ProdottoEntity;
import com.ictacademy.structureproject.entities.CatalogoProdottoEntity;

import com.ictacademy.structureproject.daos.CatalogoDao;
//import com.ictacademy.structureproject.daos.ProdottoDao;
import com.ictacademy.structureproject.daos.CatalogoProdottoDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogoProdottoService {
    private CatalogoDao catalogoDao;
    //private ProdottoDao prodottoDao;
    private CatalogoProdottoDao catalogoProdottoDao;

    public CatalogoProdottoService(){}

    public List<ProdottoEntity> getProdottiForCatalogo(long idCatalogo) throws SQLException {
        List<ProdottoEntity> lProdForCat = new ArrayList<ProdottoEntity>();
        List<CatalogoProdottoEntity> lCatProd = catalogoProdottoDao.findByIdCatalogo(idCatalogo);
        for(CatalogoProdottoEntity catProdEnt : lCatProd){
            ProdottoEntity prod = prodottoDao.findById(catProdEnt.getIdProdotto());
            lProdForCat.add(prod);
        }
        return lProdForCat;
    }

    public List<CatalogoEntity> getCataloghiForProdotto(long idProdotto) throws SQLException {
        List<CatalogoEntity> lCatForProd = new ArrayList<CatalogoEntity>();
        List<CatalogoProdottoEntity> lCatProd = catalogoProdottoDao.findByIdProdotto(idProdotto);
        for(CatalogoProdottoEntity catProdEnt : lCatProd){
            CatalogoEntity catalogo = catalogoDao.findById(catProdEnt.getIdCatalogo());
            lCatForProd.add(catalogo);
        }
        return lCatForProd;
    }
}
