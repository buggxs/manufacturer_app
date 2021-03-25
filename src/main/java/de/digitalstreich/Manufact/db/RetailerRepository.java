package de.digitalstreich.Manufact.db;

import de.digitalstreich.Manufact.model.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetailerRepository extends JpaRepository<Retailer, Long> {
}
