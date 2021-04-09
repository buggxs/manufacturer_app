package de.digitalstreich.Manufact.db;

import de.digitalstreich.Manufact.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
