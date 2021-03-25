package de.digitalstreich.Manufact.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping(value = {"", "/"})
    public String index()
    {
        return "frontend/index/index";
    }

}
