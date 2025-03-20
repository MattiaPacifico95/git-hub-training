package com.spring.fidelity.spring_fidelity.daos;

import com.spring.fidelity.spring_fidelity.model.entities.ProdottoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.sql.Timestamp;


@Repository
public interface ProdottoDao extends JpaRepository<ProdottoEntity, Long> {
    @NativeQuery("select * from prodotto where id_prodotto = ?")
    public ProdottoEntity findByID(long idProdotto);

    @NativeQuery("UPDATE into Prodotto (nome, descrizione, punti, dataCreazione) VALUES (?,?,?,?)")
    public ProdottoEntity updateProdotto(String nome, String descrizione, int punti, Timestamp dataCrerazione);
}
