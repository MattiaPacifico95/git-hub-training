package com.spring.fidelity.spring_fidelity.daos;

import com.spring.fidelity.spring_fidelity.entities.ProdottoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoDao extends JpaRepository<ProdottoEntity, Long> {
}
