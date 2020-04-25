package volha.spring.newpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import volha.spring.newpetclinic.model.Visit;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VisitMapServiceTest {

    VisitMapService visitMapService;
    Long visitId = 1L;

    @BeforeEach
    void setUp() {
        visitMapService = new VisitMapService();
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
        Visit visitSaved = visitMapService.save(Visit.builder().id(id).build());
        assertEquals(id, visitSaved.getId());
    }

    @Test
    void saveNoId(){
        Visit visitSaved = visitMapService.save(Visit.builder().build());
        assertNotNull(visitSaved);
        assertNotNull(visitSaved.getId());
    }

    @Test
    void findById() {
        Visit visit = visitMapService.findById(visitId);
        assertEquals(visitId, visit.getId());
    }
}
