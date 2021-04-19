package de.digitalstreich.Manufact.service.interfaces;

import de.digitalstreich.Manufact.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllManufacturerProducts(Long manufacturerId);

}
