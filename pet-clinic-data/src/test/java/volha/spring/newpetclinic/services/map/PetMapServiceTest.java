package volha.spring.newpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import volha.spring.newpetclinic.model.Pet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PetMapServiceTest {
    PetMapService petMapService;
    final Long petId = 1L;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        petMapService.save(Pet.builder().id(petId).build());
    }

    @Test
    void findAll() {
        Set<Pet> pets = petMapService.findAll();
        assertEquals(1, pets.size());
    }

    @Test
    void findById() {
        Pet pet = petMapService.findById(petId);
        assertEquals(petId, pet.getId());
    }

    @Test
    void deleteById() {
        petMapService.deleteById(petId);
        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Pet pet2 = Pet.builder().id(id).build();
        Pet savedPet = petMapService.save(pet2);
        assertEquals(id, savedPet.getId());
    }

    @Test
    void saveNoId(){
        Pet savedPet = petMapService.save(Pet.builder().build());
        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
    }

    @Test
    void delete() {
        petMapService.delete(petMapService.findById(petId));
        assertEquals(0, petMapService.findAll().size());
    }


}
