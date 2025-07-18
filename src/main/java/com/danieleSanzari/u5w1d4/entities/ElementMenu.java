package com.danieleSanzari.u5w1d4.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ElementMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    protected long id;
    @Column(name = "names")
    protected String name;
    @Column(name = "calories")
    protected int calories;
    @Column(name = "prices")
    protected double price;

    @Override
    public String toString() {
        return "ElementMenu{" +
                "calories=" + calories +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
