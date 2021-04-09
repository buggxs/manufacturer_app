package de.digitalstreich.Manufact.factory;

import com.github.javafaker.Faker;
import de.digitalstreich.Manufact.db.*;
import de.digitalstreich.Manufact.model.*;
import de.digitalstreich.Manufact.model.auth.Role;
import de.digitalstreich.Manufact.model.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Service
public class CategoryFactory {

    @Autowired
    private CategoryRepository categoryRepository;

    private Faker faker;

    @PostConstruct
    private void fill() {
        this.faker =   generateFaker();
    }

    private Faker generateFaker() {
        return new Faker(new Locale("de-DE"));
    }

    public void createCategories() {
        for (int i = 0; i < 40; i++) {

            categoryRepository.save(
                    new Category(
                            faker.lorem().word()
                    )
            );

        }
    }



}
