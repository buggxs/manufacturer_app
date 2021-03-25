package de.digitalstreich.Manufact.controller.backend;

import de.digitalstreich.Manufact.db.RoleRepository;
import de.digitalstreich.Manufact.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String login()
    {
        return "frontend/auth/login";
    }

    @GetMapping("/registration")
    public String register()
    {
        return "frontend/auth/registration";
    }

}
