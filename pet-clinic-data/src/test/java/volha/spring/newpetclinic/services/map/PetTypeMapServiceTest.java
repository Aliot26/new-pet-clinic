package volha.spring.newpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import volha.spring.newpetclinic.model.PetType;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PetTypeMapServiceTest {

    PetTypeMapService petTypeMapService;
    final  Long typeId = 1L;

    @BeforeEach
    void setUp() {
        petTypeMapService = new PetTypeMapService();
        petTypeMapService.save(PetType.builder().id(typeId).build());
    }

    @Test
    void findAll() {
        Set<PetType> types = petTypeMapService.findAll();
        assertEquals(1, types.size());
    }

    @Test
    void deleteById() {
        petTypeMapService.deleteById(typeId);
        assertEquals(0, petTypeMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        PetType savedType = petTypeMapService.save(PetType.builder().id(id).build());
        assertEquals(id, savedType.getId());
    }

    @Test
    void saveNoId(){
        PetType savedType = petTypeMapService.save(PetType.builder().build());
        assertNotNull(savedType);
        assertNotNull(savedType.getId());
    }

    @Test
    void delete() {
        petTypeMapService.delete(petTypeMapService.findById(typeId));
        assertEquals(0, petTypeMapService.findAll().size());
    }

    @Test
    void findById() {
        PetType type = petTypeMapService.findById(typeId);
        assertEquals(typeId, type.getId());
    }
}
