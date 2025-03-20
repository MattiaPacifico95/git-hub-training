package com.spring.fidelity.spring_fidelity.daos;

import com.spring.fidelity.spring_fidelity.entities.CatalogoEntity;
import com.spring.fidelity.spring_fidelity.entities.ProdottoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogoDao extends JpaRepository<CatalogoEntity,Long> {
    @NativeQuery("select * from catalogo where id_catalogo = ?")
    public CatalogoEntity findByID(long id_utente);

    @NativeQuery("SELECT id_prodotto FROM catalogo_prodotto WHERE id_catalogo = ?1")
    public List<Long> listProdInCat(long idCatalogo);

    @NativeQuery("DELETE FROM catalogo_prodotto WHERE id_catalogo = ?1 AND id_prodotto = ?2")
    public void rimuoviCatProd(long idCatalogo, long idProdotto);
}
