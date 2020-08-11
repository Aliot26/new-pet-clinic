package volha.spring.newpetclinic.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import volha.spring.newpetclinic.model.Owner;
import volha.spring.newpetclinic.services.OwnerService;

import java.util.Set;

/*
 *Created by olga on 11.08.2020
 */
@RestController
public class OwnerApiController{
    private final OwnerService ownerService;

    public OwnerApiController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"/api/owners"})
    public ResponseEntity<Set<Owner>> getOwners(){
        return new ResponseEntity<Set<Owner>>(ownerService.findAll(), HttpStatus.OK);
    }
}

