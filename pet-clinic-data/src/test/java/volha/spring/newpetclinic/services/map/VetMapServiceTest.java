package volha.spring.newpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import volha.spring.newpetclinic.model.Vet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VetMapServiceTest {
    VetMapService vetMapService;
    SpecialityMapService specialityMapService;
    Long vetId = 1L;

    @BeforeEach
    void setUp() {
        vetMapService = new VetMapService(new SpecialityMapService());
        vetMapService.save(Vet.builder().id(vetId).build());
    }

    @Test
    void findAll() {
        Set<Vet> vets = vetMapService.findAll();
        assertEquals(1, vets.size());
    }

    @Test
    void deleteById() {
        vetMapService.deleteById(vetId);
        assertEquals(0, vetMapService.findAll().size());
    }

    @Test
    void delete() {
        vetMapService.delete(vetMapService.findById(vetId));
        assertEquals(0, vetMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Vet savedVet = vetMapService.save(Vet.builder().id(id).build());
        assertEquals(id, savedVet.getId());
    }

    @Test
    void saveNoId(){
        Vet savedVet = vetMapService.save(Vet.builder().build());
        assertNotNull(savedVet);
        assertNotNull(savedVet.getId());
    }

    @Test
    void findById() {
        Vet vet = vetMapService.findById(vetId);
        assertEquals(vetId, vet.getId());
    }
}
