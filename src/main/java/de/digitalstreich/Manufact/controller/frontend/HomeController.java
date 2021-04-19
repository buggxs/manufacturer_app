package de.digitalstreich.Manufact.controller.frontend;

import de.digitalstreich.Manufact.db.ManufacturerRepository;
import de.digitalstreich.Manufact.factory.*;
import de.digitalstreich.Manufact.model.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    private UserFactory userFactory;
    private ProductFactory productFactory;
    private BranchFactory branchFactory;
    private CategoryFactory categoryFactory;
    private StateFactory stateFactory;
    private CountryFactory countryFactory;
    private TagFactory tagFactory;
    private ProductgroupFactory productgroupFactory;
    private ManufacturerRepository manufacturerRepository;


    @Autowired
    public HomeController(UserFactory userFactory, ProductFactory productFactory, BranchFactory branchFactory,
                          CategoryFactory categoryFactory, StateFactory stateFactory, CountryFactory countryFactory,
                          TagFactory tagFactory, ProductgroupFactory productgroupFactory, ManufacturerRepository manufacturerRepository) {
        this.userFactory = userFactory;
        this.productFactory = productFactory;
        this.branchFactory = branchFactory;
        this.categoryFactory = categoryFactory;
        this.stateFactory = stateFactory;
        this.countryFactory = countryFactory;
        this.tagFactory = tagFactory;
        this.productgroupFactory = productgroupFactory;
        this.manufacturerRepository = manufacturerRepository;
    }


    @GetMapping(value = {"", "/"})
    public String index()
    {
        return "frontend/index/index";
    }


    @GetMapping(value = {"/fake-data"})
    public String fakerData(){
        Manufacturer manufacturer = manufacturerRepository.getOne(1L);

//        countryFactory.createCountry();
//        stateFactory.createStates();
//        categoryFactory.createCategories();
//        tagFactory.createTag();
//        branchFactory.createBranches();
//        userFactory.createManufacturer();
//        productFactory.createProducts(1L);
        productgroupFactory.createProductgroup(manufacturer);



        return "frontend/index/index";
    }

}
