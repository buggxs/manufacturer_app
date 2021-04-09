package de.digitalstreich.Manufact.db;

import de.digitalstreich.Manufact.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
