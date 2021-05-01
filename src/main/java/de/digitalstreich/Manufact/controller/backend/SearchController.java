package de.digitalstreich.Manufact.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {


    @GetMapping(value = {"/manufacturer"})
    public String searchManufacturer(Model model)
    {
        return "backend/search/manufacturer";
    }


    @GetMapping(value = {"/retailer"})
    public String searchRetailer(Model model)
    {
        return "backend/search/retailer";
    }

}
