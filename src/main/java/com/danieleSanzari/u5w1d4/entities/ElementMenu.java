package com.danieleSanzari.u5w1d4.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ElementMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    protected long id;
    protected String name;
    protected int calories;
    protected double price;
}
