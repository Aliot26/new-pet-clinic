package volha.spring.newpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import volha.spring.newpetclinic.services.VetService;

/*
 *Created by olga on 16.04.2020
 */
@Controller
public class VetController {

    private  final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        System.out.println("vetcontroller");
        return "vets/index";
    }
}
