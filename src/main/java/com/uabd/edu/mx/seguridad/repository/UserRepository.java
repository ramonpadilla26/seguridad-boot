package com.uabd.edu.mx.seguridad.repository;

import com.uabd.edu.mx.seguridad.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUsersByUsername(String nombre);
}
