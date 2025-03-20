package com.spring.fidelity.spring_fidelity.daos;

import com.spring.fidelity.spring_fidelity.model.entities.CatalogoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoDao extends JpaRepository<CatalogoEntity,Long> {
    @NativeQuery("select * from catalogo where id_catalogo = ?")
    public CatalogoEntity findByID(long id_utente);
}
