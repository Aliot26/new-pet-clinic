package volha.spring.newpetclinic.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import volha.spring.newpetclinic.model.Visit;
import volha.spring.newpetclinic.services.VisitService;

import java.util.Set;

/*
 *Created by olga on 31.08.2020
 */
@Api("ApiController for Visits")
@RestController
@RequestMapping("/api")
public class VisitApiController {
    private final VisitService visitService;

    public VisitApiController(VisitService visitService) {
        this.visitService = visitService;
    }
    @ApiOperation(value = "This will get a list of visits")
    @GetMapping("/visits")
    public ResponseEntity<Set<Visit>> getVisits(){
        return new ResponseEntity<Set<Visit>>(visitService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get the visit")
    @GetMapping("/visits/{visit_id}")
    public ResponseEntity<Visit> getVisitById(@PathVariable Long visit_id){
        return new ResponseEntity<Visit>(visitService.findById(visit_id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will create new visit")
    @PostMapping("/visits")
    public ResponseEntity<Void> createVisit(@RequestBody Visit visit){
        visitService.save(visit);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "This will update visit's details")
    @PatchMapping("/visits/{visit_id}")
    public ResponseEntity<Void> updateVisit(@RequestBody Visit visit){
        visitService.save(visit);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ApiOperation(value = "This will delete the visit")
    @DeleteMapping("/visits/{visit_id}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long visit_id){
        visitService.deleteById(visit_id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
