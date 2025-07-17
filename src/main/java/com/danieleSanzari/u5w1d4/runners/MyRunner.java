package com.danieleSanzari.u5w1d4.runners;

import com.danieleSanzari.u5w1d4.entities.Pizza;
import com.danieleSanzari.u5w1d4.entities.Topping;
import com.danieleSanzari.u5w1d4.services.DrinkService;
import com.danieleSanzari.u5w1d4.services.ElementMenuService;
import com.danieleSanzari.u5w1d4.services.PizzaService;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
@Slf4j
public class MyRunner implements CommandLineRunner {
    @Autowired
    private ElementMenuService elementMenuService;
    @Autowired
    private DrinkService drinkService;
    @Autowired
    private PizzaService pizzaService;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.ITALY);

        Pizza newPizza = new Pizza(faker.country().name(),faker.random().nextInt(1000),) {
        })
    }
}
