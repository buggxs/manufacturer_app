package de.digitalstreich.Manufact.service.interfaces;

import de.digitalstreich.Manufact.model.auth.User;

public interface UserService {

    User currentLoggedInUser();

    User findByUsername(String email);

}
