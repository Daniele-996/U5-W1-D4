package com.danieleSanzari.u5w1d4.services;

import com.danieleSanzari.u5w1d4.entities.Topping;
import com.danieleSanzari.u5w1d4.exceptions.NotFoundException;
import com.danieleSanzari.u5w1d4.exceptions.ValidationException;
import com.danieleSanzari.u5w1d4.repositories.ToppingRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ToppingService {
    @Autowired
    private ToppingRepo toppingRepo;

    public void saveTopping(Topping newTopping) {
        if (newTopping.getName() == null || newTopping.getName().length() < 2)
            throw new ValidationException("il nome inserito non può essere formato da meno di due caratteri");
        toppingRepo.save(newTopping);
        log.info("Il topping : " + newTopping.getName() + " è stato salvato correttamente!");
    }

    public List<Topping> findAll() {
        return toppingRepo.findAll();
    }

    public Topping findById(long toppingId) {
        return toppingRepo.findById(toppingId).orElseThrow(() -> new NotFoundException(toppingId));
    }

    public void findByIdAndUpdate(long toppingId, Topping updateTopping) {
        Topping found = this.findById(toppingId);

        found.setName(updateTopping.getName());
        found.setCalories(updateTopping.getCalories());
        found.setPrice(updateTopping.getPrice());

        toppingRepo.save(found);

        log.info("Il topping con id: " + toppingId + " è stato modificato correttamente!");
    }

    public void findByIdAndDelete(long toppingId) {
        Topping found = this.findById(toppingId);
        toppingRepo.delete(found);
        log.info("Il topping con id: " + toppingId + " è stato cancellato correttamente!");
    }

    public void saveAll(List<Topping> newTopping) {
        for (Topping topping : newTopping) {
            try {
                this.saveTopping(topping);
            } catch (ValidationException ex) {
                log.error(ex.getMessage());
            }
        }
    }
}
