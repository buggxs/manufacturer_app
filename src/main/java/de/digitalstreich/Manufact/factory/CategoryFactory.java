package de.digitalstreich.Manufact.factory;

import de.digitalstreich.Manufact.db.*;
import de.digitalstreich.Manufact.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class CategoryFactory {

    @Autowired
    private CategoryRepository categoryRepository;

    private String[] categories = {
            "Bücher", "Elektronik & Computer", "Filme, Serien, Musik & Games",
            "Haushalt, Garten, Tier & Baumarkt", "Beauty, Drogerie & Lebensmittel",
            "Spielzeug & Baby", "Bekleidung, Schuhe , Schmuck und Accessoires",
            "Sport & Freizeit", "Auto, Motorrad & Gewerbe"
    };

    public void createCategories() {
        Arrays.stream(categories)
                .map(Category::new)
                .forEach(categoryRepository::save);
    }



}
