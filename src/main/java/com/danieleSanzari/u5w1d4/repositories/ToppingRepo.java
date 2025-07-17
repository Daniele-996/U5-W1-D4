package com.danieleSanzari.u5w1d4.repositories;

import com.danieleSanzari.u5w1d4.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingRepo extends JpaRepository<Topping, Long> {
}
