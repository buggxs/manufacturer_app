package de.digitalstreich.Manufact.controller.backend;

import de.digitalstreich.Manufact.db.UserRepository;
import de.digitalstreich.Manufact.model.Product;
import de.digitalstreich.Manufact.model.Productgroup;
import de.digitalstreich.Manufact.model.auth.User;
import de.digitalstreich.Manufact.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private ProductService productService;
    private UserRepository userRepository;

    @Autowired
    public ProductController(ProductService productService, UserRepository userRepository) {
        this.productService = productService;
        this.userRepository = userRepository;
    }

    @GetMapping("/product")
    public String index()
    {
        return "backend/product/index";
    }

    @GetMapping("/product/manage")
    public String manage(Model model, Principal principal)
    {
        System.out.println(principal.getName());
        Optional<User> userOptional = userRepository.findByEmail(principal.getName());
        User currentUser = userOptional.get();

        List<Product> products = currentUser.getManufacturer().getProducts();
        List<Productgroup> productgroups = currentUser.getManufacturer().getProductgroups();

        model.addAttribute("productgroups", productgroups);
        model.addAttribute("products", products);

        return "backend/product/manage";
    }

    @GetMapping("/product/create")
    public String create()
    {
        return "";
    }

    @GetMapping("/product/{slug}/edit")
    public String edit()
    {
        return "";
    }

    @PostMapping("/product/{id}/save")
    public String save()
    {
        return "";
    }

    @PostMapping("/product/{id}/update")
    public String update()
    {
        return "";
    }

}
