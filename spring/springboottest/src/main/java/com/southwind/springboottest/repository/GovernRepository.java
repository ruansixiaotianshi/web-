package com.southwind.springboottest.repository;

import com.southwind.springboottest.entity.Govern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GovernRepository extends JpaRepository<Govern,Integer> {
    Govern findByUsername(String username);
    Govern getByUsernameAndPassword(String username, String password);
}

