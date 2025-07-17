package com.danieleSanzari.u5w1d4.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Drink extends ElementMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
