package com.danieleSanzari.u5w1d4.runners;

import com.danieleSanzari.u5w1d4.entities.Drink;
import com.danieleSanzari.u5w1d4.entities.Pizza;
import com.danieleSanzari.u5w1d4.entities.Topping;
import com.danieleSanzari.u5w1d4.services.DrinkService;
import com.danieleSanzari.u5w1d4.services.ElementMenuService;
import com.danieleSanzari.u5w1d4.services.PizzaService;
import com.danieleSanzari.u5w1d4.services.ToppingService;
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
    @Autowired
    private ToppingService toppingService;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.ITALY);

        List<Topping> toppings = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Topping newTopping = new Topping();
            newTopping.setName(faker.food().ingredient());
            newTopping.setPrice(faker.number().randomDouble(2, 1, 5));
            newTopping.setCalories(faker.random().nextInt(50, 400));
            toppingService.saveTopping(newTopping);
            toppings.add(newTopping);
        }

        List<Pizza> pizzas = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Pizza newPizza = new Pizza();
            newPizza.setName(faker.harryPotter().character());
            newPizza.setPrice(faker.number().randomDouble(2, 5, 10));
            newPizza.setCalories(faker.random().nextInt(400, 1200));
            newPizza.setIngredients(faker.food().ingredient());
            pizzaService.savePizza(newPizza);
            pizzas.add(newPizza);
        }

        List<Drink> drinks = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Drink newDrink = new Drink();
            newDrink.setName(faker.gameOfThrones().character());
            newDrink.setPrice(faker.number().randomDouble(2, 3, 7));
            newDrink.setCalories(faker.random().nextInt(200, 450));
            drinkService.saveDrink(newDrink);
            drinks.add(newDrink);
        }
    }

}
