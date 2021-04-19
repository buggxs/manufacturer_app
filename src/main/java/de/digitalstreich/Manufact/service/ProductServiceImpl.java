package de.digitalstreich.Manufact.service;

import de.digitalstreich.Manufact.db.ProductRepository;
import de.digitalstreich.Manufact.model.Product;
import de.digitalstreich.Manufact.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllManufacturerProducts(Long manufacturerId) {
        return productRepository.findAll(manufacturerId, Sort.unsorted());
    }
}
