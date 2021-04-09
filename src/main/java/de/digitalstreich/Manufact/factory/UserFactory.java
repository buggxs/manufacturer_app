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
public class UserFactory {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    private Faker faker;

    @PostConstruct
    private void fill() {
        this.faker =   generateFaker();
    }

    private Faker generateFaker() {
        return new Faker(new Locale("de-DE"));
    }

    public User createUser() {
        Role role = roleRepository.getOne(1L);
        return new User(
                "example@test.org",
                passwordEncoder.encode("password"),
                true,
                true,
                true,
                true,
                role
        );
    }

    public Manufacturer createManufacturer() {
        Branch branch = branchRepository.getOne(1L);
        Country country = countryRepository.getOne(1L);
        State state = stateRepository.getOne(1L);
        User user = createUser();

        Manufacturer manufacturer = new Manufacturer(
                faker.company().name(),
                faker.company().url(),
                "DE8732692",
                faker.address().zipCode(),
                faker.address().city(),
                faker.address().streetName(),
                faker.internet().emailAddress(),
                true,
                faker.phoneNumber().cellPhone(),
                user,
                branch,
                country,
                state
        );

        ManufacturerDetails manufacturerDetails = new ManufacturerDetails(
                true,
                true
        );
        manufacturer.setManufacturerDetails(manufacturerDetails);

        return manufacturerRepository.save(manufacturer);
    }

}
