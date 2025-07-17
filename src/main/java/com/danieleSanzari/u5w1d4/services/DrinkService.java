package com.danieleSanzari.u5w1d4.services;

import com.danieleSanzari.u5w1d4.entities.Drink;
import com.danieleSanzari.u5w1d4.exceptions.NotFoundException;
import com.danieleSanzari.u5w1d4.exceptions.ValidationException;
import com.danieleSanzari.u5w1d4.repositories.DrinkRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DrinkService {
    @Autowired
    private DrinkRepo drinkRepo;

    public void saveDrink(Drink newDrink) {
        if (newDrink.getName() == null || newDrink.getName().length() < 2)
            throw new ValidationException("il nome inserito non può essere formato da meno di due caratteri");
        drinkRepo.save(newDrink);
        log.info("Il drink del menu : " + newDrink.getName() + " è stato salvato correttamente!");
    }

    public List<Drink> findAll() {
        return drinkRepo.findAll();
    }

    public Drink findById(long drinkId) {
        return drinkRepo.findById(drinkId).orElseThrow(() -> new NotFoundException(drinkId));
    }

    public void findByIdAndUpdate(long drinkId, Drink updatePizza) {
        Drink found = this.findById(drinkId);

        found.setName(updatePizza.getName());
        found.setCalories(updatePizza.getCalories());
        found.setPrice(updatePizza.getPrice());

        drinkRepo.save(found);

        log.info("Il drink con id: " + drinkId + " è stato modificato correttamente!");
    }

    public void findByIdAndDelete(long drinkId) {
        Drink found = this.findById(drinkId);
        drinkRepo.delete(found);
        log.info("Il drink con id: " + drinkId + " è stato cancellato correttamente!");
    }

    public void saveAll(List<Drink> newDrink) {
        for (Drink drink : newDrink) {
            try {
                this.saveDrink(drink);
            } catch (ValidationException ex) {
                log.error(ex.getMessage());
            }
        }
    }
}