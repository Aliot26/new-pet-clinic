package volha.spring.newpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import volha.spring.newpetclinic.model.Pet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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
    void findByIdExistingid() {
        Pet pet = petMapService.findById(petId);
        assertEquals(petId, pet.getId());
    }

    @Test
    void findByIdNotExistingId() {
        Pet pet = petMapService.findById(5L);
        assertNull(pet);
    }

    @Test
    void findByIdNull() {
        Pet pet = petMapService.findById(null);
        assertNull(pet);
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
    void saveByDuplicateId() {
        Long id = 1l;
        Pet pet2 = Pet.builder().id(id).build();
        Pet savedPet = petMapService.save(pet2);
        assertEquals(id, savedPet.getId());
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void saveNoId() {
        Pet savedPet = petMapService.save(Pet.builder().build());
        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
    }

    @Test
    void delete() {
        petMapService.delete(petMapService.findById(petId));
        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deleteWithWrongId() {
        Pet pet = Pet.builder().id(5L).build();
        petMapService.delete(pet);
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteWithNullId() {
        Pet pet = Pet.builder().build();
        petMapService.delete(pet);
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteNull(){
        petMapService.delete(null);
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteByIdWrongId(){
        Pet pet = Pet.builder().id(5L).build();
        petMapService.deleteById(5L);
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteByIdNullId(){
        petMapService.deleteById(null);
        assertEquals(1, petMapService.findAll().size());
    }
}
