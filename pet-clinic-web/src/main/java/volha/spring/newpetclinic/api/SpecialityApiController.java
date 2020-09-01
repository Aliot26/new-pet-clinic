package volha.spring.newpetclinic.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import volha.spring.newpetclinic.model.Speciality;
import volha.spring.newpetclinic.services.SpecialityService;

import java.util.Set;

/*
 *Created by olga on 01.09.2020
 */
@Api("ApiController for Specialities")
@RestController
@RequestMapping("/api")
public class SpecialityApiController {
    private final SpecialityService specialityService;

    public SpecialityApiController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @ApiOperation(value = "This will get list of specialities")
    @GetMapping("/specialities")
    public ResponseEntity<Set<Speciality>> getSpecialities(){
        return new ResponseEntity<Set<Speciality>>(specialityService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get the speciality")
    @GetMapping("/specialities/{speciality_id}")
    public ResponseEntity<Speciality> getPetById(@PathVariable Long speciality_id){
        return new ResponseEntity<Speciality>(specialityService.findById(speciality_id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will create new speciality")
    @PostMapping("/specialities")
    public ResponseEntity<Void> createSpeciality(@RequestBody Speciality speciality){
        specialityService.save(speciality);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "This will update speciality's details")
    @PatchMapping("/specialities/{speciality_id}")
    public ResponseEntity<Void> updateSpeciality(@RequestBody Speciality speciality){
        specialityService.save(speciality);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ApiOperation(value = "This will delete the speciality")
    @DeleteMapping("/specialities/{speciality_id}")
    public ResponseEntity<Void> deleteSpeciality(@PathVariable Long speciality_id){
        specialityService.deleteById(speciality_id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
