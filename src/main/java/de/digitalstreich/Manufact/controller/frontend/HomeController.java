package de.digitalstreich.Manufact.controller.frontend;

import de.digitalstreich.Manufact.db.ManufacturerRepository;
import de.digitalstreich.Manufact.db.UserRepository;
import de.digitalstreich.Manufact.factory.ProductFactory;
import de.digitalstreich.Manufact.factory.UserFactory;
import de.digitalstreich.Manufact.model.Manufacturer;
import de.digitalstreich.Manufact.model.ManufacturerDetails;
import de.digitalstreich.Manufact.model.Product;
import de.digitalstreich.Manufact.model.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private UserFactory userFactory;

    @Autowired
    private ProductFactory productFactory;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;


    @GetMapping(value = {"", "/"})
    public String index()
    {
        return "frontend/index/index";
    }

    @GetMapping(value = {"/faker"})
    public String faker() {


        // userFactory.createManufacturer();
        /*
        Manufacturer manufacturer = userFactory.userWithManufacturer();
        ManufacturerDetails manufacturerDetails = new ManufacturerDetails(
                true,
                true
        );
        manufacturer.setManufacturerDetails(manufacturerDetails);
        manufacturerRepository.save(manufacturer);
        */

        return "frontend/index/index";
    }

    @GetMapping(value = {"/faker-products"})
    public String fakerProducts(){

        productFactory.createProducts(1L);

        return "frontend/index/index";
    }

}
