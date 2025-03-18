package com.spring.fidelity.spring_fidelity.daos;

import com.spring.fidelity.spring_fidelity.entities.CatalogoProdottoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // metodi CRUD già forniti da SPRING
public interface CatalogoProdottoDao extends JpaRepository<CatalogoProdottoEntity, Long> {

    @Override
    List<CatalogoProdottoEntity> findAll();

    @Query("select ctpd from CatalogoProdottoEntity ctpd where ctpd.idCatalogo = ?1")
    List<CatalogoProdottoEntity> findByIdCatalogo(Long idCatalogo);

    @Query("select ctpd from CatalogoProdottoEntity ctpd where ctpd.idProdotto = ?1")
    List<CatalogoProdottoEntity> findByIdProdotto(Long idProdotto);

    @Query("select ctpd from CatalogoProdottoEntity ctpd where ctpd.idCatalogo = ?1 and ctpd.idProdotto = ?2")
    CatalogoProdottoEntity findByIdCatProd(Long idCatalogo, Long idProdotto);

    @Query("delete from CatalogoProdottoEntity ctpd where ctpd.idCatalogo = ?1 and ctpd.idProdotto = ?2")
    Long deleteCatProd(Long idCatalogo, Long idProdotto);
}
