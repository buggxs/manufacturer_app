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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class ProductFactory {

    private UserRepository userRepository;
    private ProductRepository productRepository;

    @Autowired
    public ProductFactory(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    private Faker faker;

    @PostConstruct
    private void fill() {
        this.faker =   generateFaker();
    }

    private Faker generateFaker() {
        return new Faker(new Locale("de-DE"));
    }

    public void createProducts(Long userId) {
        User user = userRepository.getOne(userId);
        List<Product> productList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            productList.add(
                    new Product(
                            faker.commerce().productName(),
                            UUID.randomUUID().toString(),
                            faker.number().randomDouble(2, 0, 1000),
                            faker.number().randomDouble(2, 0, 100),
                            faker.number().randomDouble(2, 0, 100),
                            faker.number().randomDouble(2, 0, 100),
                            faker.number().randomDouble(2, 0, 100),
                            faker.number().randomDouble(2, 0, 100),
                            UUID.randomUUID().toString(),
                            faker.lorem().fixedString(8),
                            faker.lorem().fixedString(8),
                            faker.date().birthday(),
                            faker.lorem().sentence(),
                            user.getManufacturer()
                    )
            );
        }

        productRepository.saveAll(productList);

    }




}
