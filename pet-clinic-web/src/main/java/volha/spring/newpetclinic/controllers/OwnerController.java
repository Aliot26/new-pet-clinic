package volha.spring.newpetclinic.controllers;

/*
 *Created by olga on 16.04.2020
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {
    @RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
    public String listOwners(){
        return "owners/index";
    }
}
