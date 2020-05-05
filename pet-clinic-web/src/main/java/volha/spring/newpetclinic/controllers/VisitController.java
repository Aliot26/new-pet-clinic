package volha.spring.newpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import volha.spring.newpetclinic.model.Pet;
import volha.spring.newpetclinic.model.Visit;
import volha.spring.newpetclinic.services.PetService;
import volha.spring.newpetclinic.services.VisitServise;

import javax.validation.Valid;

/*
 *Created by olga on 05.05.2020
 */

@Controller
public class VisitController {
    private static final String VIEWS_VISITS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdateVisitForm";

    private final VisitServise visitServise;
    private final PetService petService;

    public VisitController(VisitServise visitServise, PetService petService) {
        this.visitServise = visitServise;
        this.petService = petService;
    }

    @InitBinder
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Model model) {
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    @GetMapping("owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable("petId") Long petId, Model model){
        return VIEWS_VISITS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("owners/*/pets/{petId}/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result){
        if(result.hasErrors()){
            return VIEWS_VISITS_CREATE_OR_UPDATE_FORM;
        }else {
            visitServise.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
}
