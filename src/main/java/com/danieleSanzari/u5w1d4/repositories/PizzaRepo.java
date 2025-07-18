package com.danieleSanzari.u5w1d4.repositories;

import com.danieleSanzari.u5w1d4.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepo extends JpaRepository<Pizza, Long> {
    List<Pizza> findByNameStartingWith(String name);
}
