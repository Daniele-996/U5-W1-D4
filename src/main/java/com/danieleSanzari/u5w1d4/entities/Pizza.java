package com.danieleSanzari.u5w1d4.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pizza extends ElementMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @ManyToMany(mappedBy = "pizzas")
    private List<Topping> toppings;
    private String ingredients;
}
