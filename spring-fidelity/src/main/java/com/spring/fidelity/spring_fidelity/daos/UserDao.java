package com.spring.fidelity.spring_fidelity.daos;


import com.spring.fidelity.spring_fidelity.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity,Long> {
    @Query("select u from UserEntity u where u.email=?4")
    public UserEntity findByEmail(String email);

    @Query("select u from UserEntity u where u.idUtente = ?1")
    public UserEntity findBy(Long id_utente);

    @NativeQuery("INSERT INTO utente (nome, cognome, email, dataNascita) VALUES (?, ?, ?, ?)")
    public boolean createUser(String nome, String cognome, String email, Timestamp dataNascita);

}
