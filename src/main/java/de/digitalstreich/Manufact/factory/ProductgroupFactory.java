package de.digitalstreich.Manufact.factory;

import de.digitalstreich.Manufact.db.ProductRepository;
import de.digitalstreich.Manufact.db.ProductgroupRepository;
import de.digitalstreich.Manufact.model.Manufacturer;
import de.digitalstreich.Manufact.model.Product;
import de.digitalstreich.Manufact.model.Productgroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductgroupFactory {


    private final ProductgroupRepository productgroupRepository;
    private final ProductRepository productRepository;


    @Autowired
    public ProductgroupFactory(ProductgroupRepository productgroupRepository, ProductRepository productRepository) {
        this.productgroupRepository = productgroupRepository;
        this.productRepository = productRepository;
    }


    public void createProductgroup(Manufacturer manufacturer)
    {
        List<Product> productList = productRepository.findAll();
        Productgroup productgroup = new Productgroup(
                "FooRetailer",
                "Produkte für den FooRetailer",
                productList,
                manufacturer
        );

        productgroupRepository.save(productgroup);

    }


}
