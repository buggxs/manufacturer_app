package de.digitalstreich.Manufact.service;

import de.digitalstreich.Manufact.db.ProductRepository;
import de.digitalstreich.Manufact.model.Manufacturer;
import de.digitalstreich.Manufact.model.Product;
import de.digitalstreich.Manufact.service.interfaces.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Sort;
import java.util.*;

class ProductServiceImplTest {

    private ProductRepository productRepository = Mockito.mock(ProductRepository.class);

    @Test
    @DisplayName("find all manufacturer products")
    void test_findAllManufacturerProducts() {

        ProductService productService = new ProductServiceImpl(productRepository);

        Manufacturer manufacturer = new Manufacturer(111L, "Käse Gmbh", "",
                "", "", "", "",
                "",true, "", null, null, null, null);
        Product product = new Product(123L, "Rockstar", "11223344", 1.89, manufacturer);
        Product product2 = new Product(124L, "Monster", "11223355", 1.89, manufacturer);
        List<Product> products = Collections.singletonList(product);

        Mockito.doReturn(products).when(productRepository).findAll(111L, Sort.unsorted());

        List<Product> foundProducts = productService.findAllManufacturerProducts(111L);

        Assertions.assertThat(foundProducts).contains(product);
        Assertions.assertThat(foundProducts).doesNotContainSequence(product2);




    }
}