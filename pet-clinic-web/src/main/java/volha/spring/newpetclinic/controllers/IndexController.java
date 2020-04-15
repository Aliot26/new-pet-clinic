package volha.spring.newpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *Created by olga on 15.04.2020
 */
@Controller
public class IndexController {
    @RequestMapping({"", "/", "index", "index.html"})
    public String index(){
        return "index";
    }
}
