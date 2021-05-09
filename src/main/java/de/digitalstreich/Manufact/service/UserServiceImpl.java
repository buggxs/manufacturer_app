package de.digitalstreich.Manufact.service;

import de.digitalstreich.Manufact.db.UserRepository;
import de.digitalstreich.Manufact.exceptions.ManufactException;
import de.digitalstreich.Manufact.model.auth.User;
import de.digitalstreich.Manufact.service.interfaces.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User currentLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return findByUsername(currentPrincipalName);
    }

    @Override
    public User findByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ManufactException("Es konnte kein User mit dieser Email ermittelt werden."));

    }
}
