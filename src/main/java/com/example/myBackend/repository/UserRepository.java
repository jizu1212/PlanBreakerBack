package com.example.myBackend.repository;

import com.example.myBackend.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends org.springframework.data.repository.CrudRepository<User, Long>{
    public Optional<User> findByUsername(String username) ;
    public Optional<User> findByEmail(String email);
    // method to check if the user exists
    public boolean existsByUsername(String username);

}