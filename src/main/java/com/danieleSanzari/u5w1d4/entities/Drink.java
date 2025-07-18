package com.danieleSanzari.u5w1d4.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "drinks")
@Setter
@Getter
@NoArgsConstructor
public class Drink extends ElementMenu {

    public Drink(long id, String name, int calories, double price) {
        super(id, name, calories, price);
    }
}
