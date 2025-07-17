package com.danieleSanzari.u5w1d4.services;

import com.danieleSanzari.u5w1d4.entities.ElementMenu;
import com.danieleSanzari.u5w1d4.exceptions.NotFoundException;
import com.danieleSanzari.u5w1d4.exceptions.ValidationException;
import com.danieleSanzari.u5w1d4.repositories.ElementMenuRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ElementMenuService {
    @Autowired
    private ElementMenuRepo elementMenuRepo;

    public void saveElement(ElementMenu newElement) {
        if (newElement.getName().length() < 2)
            throw new ValidationException("il nome inserito non può essere formato da meno di due caratteri");
        elementMenuRepo.save(newElement);
        log.info("L'elemento del menu : " + newElement.getName() + " è stato salvato correttamente!");
    }

    public List<ElementMenu> findAll() {
        return elementMenuRepo.findAll();
    }

    public ElementMenu findById(long elementId) {
        return elementMenuRepo.findById(elementId).orElseThrow(() -> new NotFoundException(elementId));
    }

    public void findByIdAndUpdate(long elementId, ElementMenu updateElement) {
        ElementMenu found = this.findById(elementId);

        found.setName(updateElement.getName());
        found.setCalories(updateElement.getCalories());
        found.setPrice(updateElement.getPrice());

        elementMenuRepo.save(found);

        log.info("L'elemento con id: " + elementId + " è stato modificato correttamente!");
    }

    public void findByIdAndDelete(long elementId) {
        ElementMenu found = this.findById(elementId);
        elementMenuRepo.delete(found);
        log.info("L'elemento con id: " + elementId + " è stato cancellato correttamente!");
    }
}
