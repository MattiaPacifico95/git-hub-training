package com.ictacademy.structureproject.services; // import package services

// import entities utili
import com.ictacademy.structureproject.entities.CatalogoEntity;
//import com.ictacademy.structureproject.entities.ProdottoEntity;
import com.ictacademy.structureproject.entities.CatalogoProdottoEntity;

// import daos utili
import com.ictacademy.structureproject.daos.CatalogoDao;
//import com.ictacademy.structureproject.daos.ProdottoDao;
import com.ictacademy.structureproject.daos.CatalogoProdottoDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogoProdottoService {
    // oggetti per richiamare metodi daos
    private CatalogoDao catalogoDao;
    //private ProdottoDao prodottoDao;
    private CatalogoProdottoDao catalogoProdottoDao;

    public CatalogoProdottoService(){} // costruttore vuoto

    // funzione ritorna lista di prodotti dello stesso catalogo
    public List<ProdottoEntity> getProdottiForCatalogo(long idCatalogo) throws SQLException {
        List<ProdottoEntity> lProdForCat = new ArrayList<ProdottoEntity>();
        List<CatalogoProdottoEntity> lCatProd = catalogoProdottoDao.findByIdCatalogo(idCatalogo);
        for(CatalogoProdottoEntity catProdEnt : lCatProd){
            ProdottoEntity prod = prodottoDao.findById(catProdEnt.getIdProdotto());
            lProdForCat.add(prod);
        }
        return lProdForCat;
    }

    // funzione ritorna lista di cataloghi per lo stesso prodotto
    public List<CatalogoEntity> getCataloghiForProdotto(long idProdotto) throws SQLException {
        List<CatalogoEntity> lCatForProd = new ArrayList<CatalogoEntity>(); // creo lista di cataloghi vuota per output
        List<CatalogoProdottoEntity> lCatProd = catalogoProdottoDao.findByIdProdotto(idProdotto); // ottengo lista ID di cataloghi per prodotto
        for(CatalogoProdottoEntity catProdEnt : lCatProd){ // ciclo su lista
            CatalogoEntity catalogo = catalogoDao.findById(catProdEnt.getIdCatalogo()); // ottengo oggetto catalogo per ogni elemento
            lCatForProd.add(catalogo); // aggiungo catalogo a lista
        }
        return lCatForProd; // ritorno lista
    }

    public boolean aggiungiProdAlCat(long idProdotto, long idCatalogo) throws SQLException {

        if(catalogoProdottoDao.isProdottoInCatalogo(idProdotto, idCatalogo)){
            System.out.println("Prodotto già in catalogo.");
            return false;
        }

        return catalogoProdottoDao.createCatalogoProdotto(idCatalogo, idProdotto);
    }

    public boolean rimuoviProdDaCat(long idProdotto, long idCatalogo) throws SQLException {

        if(catalogoProdottoDao.isProdottoInCatalogo(idProdotto, idCatalogo)){

            return catalogoProdottoDao.deleteCatalogoProdotto(idCatalogo, idProdotto);
        }

        System.out.println("Prodotto non presente in catalogo.");
        return false;
    }
}
