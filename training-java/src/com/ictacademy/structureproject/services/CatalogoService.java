package com.ictacademy.structureproject.services;


import com.ictacademy.structureproject.daos.CatalogoDao;
import com.ictacademy.structureproject.daos.ProdottoDao;
import com.ictacademy.structureproject.daos.CatalogoProdottoDao;
import com.ictacademy.structureproject.daos.UserDao;
import com.ictacademy.structureproject.entities.CatalogoEntity;
import com.ictacademy.structureproject.entities.ProdottoEntity;
import com.ictacademy.structureproject.entities.CatalogoProdottoEntity;
import com.ictacademy.structureproject.entities.UserEntity;

public class CatalogoService {

    CatalogoDao catalogoDao = new CatalogoDao();
    ProdottoDao prodottoDao = new ProdottoDao();
    CatalogoProdottoDao catalogoProdottoDao = new CatalogoProdottoDao();
    CatalogoProdottoService catalogoProdottoService = new CatalogoProdottoService();
    UserEntity userEntity = new UserEntity();

    //lista prodotti con prezzo e descrizione... penso?
    public List<ProdottoEntity> elencaProdotti(long idCatalogo) {

        return catalogoProdottoService.getProdottiForCatalogo(idCatalogo);

    }

    //questo dovrebbe far aggiornare il catalogo per l'admin
    public boolean gestisciCatalogo (){
        boolean catAggiornato;
        if (userEntity.getIdRuolo() != 1) {
            return catAggiornato = false;
        }

        

    }



    
}
