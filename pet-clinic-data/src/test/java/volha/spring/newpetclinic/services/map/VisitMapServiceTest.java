package volha.spring.newpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import volha.spring.newpetclinic.model.Owner;
import volha.spring.newpetclinic.model.Pet;
import volha.spring.newpetclinic.model.Visit;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VisitMapServiceTest {

    VisitMapService visitMapService;
    Long visitId = 1L;

    @BeforeEach
    void setUp() {
        visitMapService = new VisitMapService();
        Owner owner = Owner.builder().id(2L).build();
        Pet pet = Pet.builder().id(2L).owner(owner).build();
        visitMapService.save(Visit.builder().id(visitId).date(LocalDate.now()).pet(pet).build());
    }

    Owner prepareOwner(){
        return Owner.builder().id(2L).build();
    }

    Pet preparePet(){
        return Pet.builder().id(2l).owner(prepareOwner()).build();
    }

    @Test
    void findAll() {
        Set<Visit> visits = visitMapService.findAll();
        assertEquals(1, visits.size());
    }

    @Test
    void deleteById() {
        visitMapService.deleteById(visitId);
        assertEquals(0, visitMapService.findAll().size());
    }

    @Test
    void delete() {
        visitMapService.delete(visitMapService.findById(visitId));
        assertEquals(0, visitMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Visit visitSaved = visitMapService.save(Visit.builder().id(id).pet(preparePet()).build());
        assertEquals(id, visitSaved.getId());
    }

    @Test
    void saveNoId(){
        Visit visitSaved = visitMapService.save(Visit.builder().pet(preparePet()).build());
        assertNotNull(visitSaved);
        assertNotNull(visitSaved.getId());
    }

    @Test
    void findById() {
        Visit visit = visitMapService.findById(visitId);
        assertEquals(visitId, visit.getId());
    }
}
