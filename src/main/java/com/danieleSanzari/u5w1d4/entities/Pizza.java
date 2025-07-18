package com.danieleSanzari.u5w1d4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pizzas")
@Setter
@Getter
@NoArgsConstructor
public class Pizza extends ElementMenu {
    private String ingredients;
    @ManyToMany
    @JoinTable(name = "pizzas_toppings",
            joinColumns = @JoinColumn(name = "pizza_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "topping_id", nullable = false))
    private List<Topping> toppings;

    public Pizza(long id, String name, int calories, double price, String ingredients, List<Topping> toppings) {
        super(id, name, calories, price);
        this.ingredients = ingredients;
        this.toppings = toppings;
    }
}
