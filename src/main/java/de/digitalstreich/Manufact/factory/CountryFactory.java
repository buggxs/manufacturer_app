package de.digitalstreich.Manufact.factory;

import de.digitalstreich.Manufact.db.CountryRepository;
import de.digitalstreich.Manufact.db.StateRepository;
import de.digitalstreich.Manufact.model.Country;
import de.digitalstreich.Manufact.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryFactory {

    @Autowired
    private CountryRepository countryRepository;

    public void createCountry() {

        List<Country> countryList = Arrays.asList(new Country[]{
                new Country("Deutschland"),
                new Country("Österreich"),
                new Country("Schweiz")
        });

        countryRepository.saveAll(countryList);

    }

}
