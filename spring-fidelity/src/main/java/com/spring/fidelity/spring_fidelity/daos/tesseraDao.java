package com.spring.fidelity.spring_fidelity.daos;

import com.spring.fidelity.spring_fidelity.entities.TesseraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface tesseraDao extends JpaRepository<tesseraDao, Long> {
    @NativeQuery("select * from tessera where id_tessera = ?")
    public TesseraEntity findByID(long id_tessera);
//    @Query("select u from TesseraEntity u where u.idTessera = ?1")
//    public  TesseraEntity findById(long id_tessera);
}
