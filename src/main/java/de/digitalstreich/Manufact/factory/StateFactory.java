package de.digitalstreich.Manufact.factory;

import com.github.javafaker.Faker;
import de.digitalstreich.Manufact.db.CategoryRepository;
import de.digitalstreich.Manufact.db.StateRepository;
import de.digitalstreich.Manufact.model.Category;
import de.digitalstreich.Manufact.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StateFactory {

    @Autowired
    private StateRepository stateRepository;

    public void createStates() {

        List<State> statesList = Arrays.asList(new State[]{
                new State("Hessen"),
                new State("Baden-Württemberg"),
                new State("Bayern"),
                new State("Berlin"),
                new State("Brandenburg"),
                new State("Bremen"),
                new State("Hamburg"),
                new State("Mecklenburg-Vorpommern"),
                new State("Niedersachsen"),
                new State("Nordrhein-Westfalen"),
                new State("Rheinland-Pfalz"),
                new State("Saarland"),
                new State("Sachsen"),
                new State("Sachsen-Anhalt"),
                new State("Schleswig-Holstein"),
                new State("Thüringen"),
        });

        stateRepository.saveAll(statesList);

    }

}
