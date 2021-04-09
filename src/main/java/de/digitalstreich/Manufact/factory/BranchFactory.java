package de.digitalstreich.Manufact.factory;

import com.github.javafaker.Faker;
import de.digitalstreich.Manufact.db.BranchRepository;
import de.digitalstreich.Manufact.db.CategoryRepository;
import de.digitalstreich.Manufact.model.Branch;
import de.digitalstreich.Manufact.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Service
public class BranchFactory {

    @Autowired
    private BranchRepository branchRepository;

    private Faker faker;

    @PostConstruct
    private void fill() {
        this.faker =   generateFaker();
    }

    private Faker generateFaker() {
        return new Faker(new Locale("de-DE"));
    }

    public void createBranches() {
        for (int i = 0; i < 40; i++) {

            branchRepository.save(
                    new Branch(
                            faker.lorem().word()
                    )
            );

        }
    }

}
