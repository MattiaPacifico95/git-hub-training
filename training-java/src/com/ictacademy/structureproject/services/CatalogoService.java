package com.ictacademy.structureproject.services;


import com.ictacademy.structureproject.daos.CatalogoDao;
import com.ictacademy.structureproject.daos.ProdottoDao;
import com.ictacademy.structureproject.daos.CatalogoProdottoDao;
import com.ictacademy.structureproject.entities.CatalogoEntity;
import com.ictacademy.structureproject.entities.ProdottoEntity;
import com.ictacademy.structureproject.entities.CatalogoProdottoEntity;

public class CatalogoService {

    CatalogoDao catalogoDao = new CatalogoDao();
    ProdottoDao prodottoDao = new ProdottoDao();
    CatalogoProdottoDao catalogoProdottoDao = new CatalogoProdottoDao();
    CatalogoProdottoService catalogoProdottoService = new CatalogoProdottoService();


    public List<ProdottoEntity> elencaProdotti(long idCatalogo) {

        return catalogoProdottoService.getProdottiForCatalogo(idCatalogo);

    }

    
}
