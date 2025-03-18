package com.spring.fidelity.spring_fidelity.daos;


import com.spring.fidelity.spring_fidelity.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import static org.springframework.data.jpa.repository.JpaRepository.*;

@Repository
public interface UserDao extends JpaRepository<UserEntity,Long> {
    UserEntity ue = null;



    //ue.
}
