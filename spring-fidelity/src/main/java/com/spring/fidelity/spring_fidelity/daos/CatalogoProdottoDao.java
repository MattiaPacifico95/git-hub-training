package com.spring.fidelity.spring_fidelity.daos;

import com.spring.fidelity.spring_fidelity.entities.CatalogoProdottoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // metodi CRUD già forniti da SPRING
public interface CatalogoProdottoDao extends JpaRepository<CatalogoProdottoEntity, Long> {

}
