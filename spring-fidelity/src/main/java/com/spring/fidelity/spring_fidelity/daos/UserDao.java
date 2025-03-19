package com.spring.fidelity.spring_fidelity.daos;


import com.spring.fidelity.spring_fidelity.entities.TesseraEntity;
import com.spring.fidelity.spring_fidelity.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import static org.springframework.data.jpa.repository.JpaRepository.*;

@Repository
public interface UserDao extends JpaRepository<UserEntity,Long> {
    @NativeQuery("select * from utente where id_utente = ?")
    public UserEntity findByID(long id_utente);



    //ue.
}
