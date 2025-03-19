package com.spring.fidelity.spring_fidelity.services;

import com.spring.fidelity.spring_fidelity.entities.CatalogoEntity;
import com.spring.fidelity.spring_fidelity.entities.ProdottoEntity;
import com.spring.fidelity.spring_fidelity.entities.CatalogoProdottoEntity;

import com.spring.fidelity.spring_fidelity.daos.CatalogoDao;
import com.spring.fidelity.spring_fidelity.daos.ProdottoDao;
import com.spring.fidelity.spring_fidelity.daos.CatalogoProdottoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogoProdottoService {

    private CatalogoDao catalogoDao;
    private ProdottoDao prodottoDao;
    private CatalogoProdottoDao catProdDao;

    public CatalogoProdottoService(CatalogoProdottoDao catProdDao){
        this.catProdDao = catProdDao;
    }

    public List<ProdottoEntity> getProdottiForCatalogo(Long idCatalogo){
        List<ProdottoEntity> lProdForCat = new ArrayList<ProdottoEntity>();
        List<CatalogoProdottoEntity> lCatProd = catProdDao.findByIdCatalogo(idCatalogo);
        for(CatalogoProdottoEntity catProdEnt : lCatProd){
            ProdottoEntity prod = prodottoDao.findById(catProdEnt.getIdProdotto());
            lProdForCat.add(prod);
        }
        return lProdForCat;
    }

    public List<CatalogoEntity> getCataloghiForProdotto(Long idProdotto){
        List<CatalogoEntity> lCatForProd = new ArrayList<CatalogoEntity>(); // creo lista di cataloghi vuota per output
        List<CatalogoProdottoEntity> lCatProd = catProdDao.findByIdProdotto(idProdotto); // ottengo lista ID di cataloghi per prodotto
        for(CatalogoProdottoEntity catProdEnt : lCatProd){ // ciclo su lista
            CatalogoEntity catalogo = catalogoDao.findById(catProdEnt.getIdCatalogo()); // ottengo oggetto catalogo per ogni elemento
            lCatForProd.add(catalogo); // aggiungo catalogo a lista
        }
        return lCatForProd; // ritorno lista
    }

    public boolean aggiungiProdAlCat(Long idProdotto, Long idCatalogo){

        /*ProdottoEntity prod = prodottoDao.findById(idProdotto);
        CatalogoEntity cat = catalogoDao.findById(idCatalogo);
        if(prod.getIdProdotto()==null || cat.getIdCatalogo()==null){
            System.out.println("Prodotto o catalogo non esistenti.");
            return false;
        }*/
        CatalogoProdottoEntity catProd = catProdDao.findByIdCatProd(idCatalogo, idProdotto);
        if(catProd.getIdCatalogo().equals(idCatalogo) && catProd.getIdProdotto().equals(idProdotto)){
            System.out.println("Questo prodotto si trova già nel catalogo.");
            return false;
        }
        catProd.setIdCatalogo(idCatalogo);
        catProd.setIdProdotto(idProdotto);
        catProdDao.saveAndFlush(catProd);
        return true;
    }

    public boolean rimuoviProdDalCat(Long idProdotto, Long idCatalogo){

        CatalogoProdottoEntity catProd = catProdDao.findByIdCatProd(idCatalogo, idProdotto);
        if(catProd.getIdCatalogo().equals(idCatalogo) && catProd.getIdProdotto().equals(idProdotto)){
            Long res = catProdDao.deleteCatProd(idCatalogo, idProdotto);
            if(res>0){
                return true;
            } else {
                System.out.println("Qualcosa è andato storto.");
                return false;
            }
        }
        System.out.println("Questo prodotto non si trova nel catalogo.");
        return false;
    }
}
