package de.digitalstreich.Manufact.db;

import de.digitalstreich.Manufact.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
