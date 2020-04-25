package volha.spring.newpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import volha.spring.newpetclinic.model.Speciality;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SpecialityMapServiceTest {

    SpecialityMapService specialityMapService;
    final Long specId = 1L;

    @BeforeEach
    void setUp() {
        specialityMapService = new SpecialityMapService();
    }

    @Test
    void findAll() {
        Set<Speciality> specialities = specialityMapService.findAll();
        assertEquals(1, specialities.size());
    }

    @Test
    void deleteById() {
        specialityMapService.deleteById(specId);
        assertEquals(0, specialityMapService.findAll().size());
    }

    @Test
    void delete() {
        specialityMapService.delete(specialityMapService.findById(specId));
        assertEquals(0, specialityMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Speciality specSaved = specialityMapService.save(Speciality.builder().id(id).build());
        assertEquals(id, specSaved.getId());
    }

    @Test
    void saveNoId(){
        Speciality specSaved = specialityMapService.save(Speciality.builder().build());
        assertNotNull(specSaved);
        assertNotNull(specSaved.getId());
    }

    @Test
    void findById() {
        Speciality spec = specialityMapService.findById(specId);
        assertEquals(specId, spec.getId());
    }
}
