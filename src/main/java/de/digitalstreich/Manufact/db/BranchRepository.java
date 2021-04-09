package de.digitalstreich.Manufact.db;

import de.digitalstreich.Manufact.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
