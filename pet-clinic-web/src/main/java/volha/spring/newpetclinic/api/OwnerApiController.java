package volha.spring.newpetclinic.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import volha.spring.newpetclinic.model.Owner;
import volha.spring.newpetclinic.services.OwnerService;

import java.util.Set;

/*
 *Created by olga on 11.08.2020
 */
@Api("OwnerController for aplication Pet Clinic")
@RestController
@RequestMapping("/api")
public class OwnerApiController{
    private final OwnerService ownerService;

    public OwnerApiController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @ApiOperation(value = "This will get a list of owners", notes = "In this list we have pets")
    @GetMapping("/owners")
    public ResponseEntity<Set<Owner>> getOwners(){
        return new ResponseEntity<Set<Owner>>(ownerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/owners/{owner_id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long owner_id){
        return new ResponseEntity<Owner>(ownerService.findById(owner_id), HttpStatus.OK);
    }
}

