package de.digitalstreich.Manufact.factory;

import com.github.javafaker.Faker;
import de.digitalstreich.Manufact.db.CategoryRepository;
import de.digitalstreich.Manufact.db.TagRepository;
import de.digitalstreich.Manufact.model.Category;
import de.digitalstreich.Manufact.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Service
public class TagFactory {

    @Autowired
    private TagRepository tagRepository;

    private Faker faker;

    @PostConstruct
    private void fill() {
        this.faker =   generateFaker();
    }

    private Faker generateFaker() {
        return new Faker(new Locale("de-DE"));
    }

    public void createTag() {
        for (int i = 0; i < 40; i++) {
            tagRepository.save(
                    new Tag(
                            faker.lorem().word()
                    )
            );

        }
    }


}
