package de.digitalstreich.Manufact.db;

import de.digitalstreich.Manufact.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p from Product p where p.manufacturer.id = :manufacturerId")
    List<Product> findAll(@Param("manufacturerId") Long manufacturerId, Sort sort);
}
