package com.danieleSanzari.u5w1d4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "toppings")
@Setter
@Getter
@NoArgsConstructor
public class Topping extends ElementMenu {
    @ManyToMany(mappedBy = "toppings")
    private List<Pizza> pizzas;

    public Topping(long id, String name, int calories, double price, List<Pizza> pizzas) {
        super(id, name, calories, price);
        this.pizzas = pizzas;
    }
}
