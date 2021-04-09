package de.digitalstreich.Manufact.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @GetMapping("/product")
    public String index()
    {
        return "backend/produkt/index";
    }

    @GetMapping("/product/manage")
    public String manage()
    {
        return "backend/produkt/manage";
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
