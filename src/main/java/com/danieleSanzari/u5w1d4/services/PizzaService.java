package com.danieleSanzari.u5w1d4.services;

import com.danieleSanzari.u5w1d4.entities.Pizza;
import com.danieleSanzari.u5w1d4.exceptions.NotFoundException;
import com.danieleSanzari.u5w1d4.exceptions.ValidationException;
import com.danieleSanzari.u5w1d4.repositories.PizzaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PizzaService {
    @Autowired
    private PizzaRepo pizzaRepo;

    public void savePizza(Pizza newPizza) {
        if (newPizza.getName() == null || newPizza.getName().length() < 2)
            throw new ValidationException("il nome inserito non può essere formato da meno di due caratteri");
        pizzaRepo.save(newPizza);
        log.info("La pizza del menu : " + newPizza.getName() + " è stato salvato correttamente!");
    }

    public List<Pizza> findAll() {
        return pizzaRepo.findAll();
    }

    public Pizza findById(long pizzaId) {
        return pizzaRepo.findById(pizzaId).orElseThrow(() -> new NotFoundException(pizzaId));
    }

    public void findByIdAndUpdate(long pizzaId, Pizza updatePizza) {
        Pizza found = this.findById(pizzaId);

        found.setName(updatePizza.getName());
        found.setCalories(updatePizza.getCalories());
        found.setPrice(updatePizza.getPrice());

        pizzaRepo.save(found);

        log.info("La pizza con id: " + pizzaId + " è stato modificato correttamente!");
    }

    public void findByIdAndDelete(long pizzaId) {
        Pizza found = this.findById(pizzaId);
        pizzaRepo.delete(found);
        log.info("La pizza con id: " + pizzaId + " è stato cancellato correttamente!");
    }

    public void saveAll(List<Pizza> newPizza) {
        for (Pizza pizza : newPizza) {
            try {
                this.savePizza(pizza);
            } catch (ValidationException ex) {
                log.error(ex.getMessage());
            }
        }
    }

    public List<Pizza> filterByNameStartsWith(String partialName) {
        return this.pizzaRepo.findByNameStartingWith(partialName);
    }

}
