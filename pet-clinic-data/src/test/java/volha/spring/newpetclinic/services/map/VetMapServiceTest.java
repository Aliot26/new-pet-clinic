package volha.spring.newpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import volha.spring.newpetclinic.model.Speciality;
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
        specialityMapService = new SpecialityMapService();
        specialityMapService.save(Speciality.builder().id(2L).build());
        vetMapService = new VetMapService(specialityMapService);
        vetMapService.save(Vet.builder().id(vetId).specialities(specialityMapService.findAll()).build());
    }

    Set<Speciality> prepareSpeciality(){
        specialityMapService.save(Speciality.builder().id(2L).build());
        Set<Speciality> specialities = specialityMapService.findAll();
        return specialities;
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
        Vet savedVet = vetMapService.save(Vet.builder().id(id).specialities(prepareSpeciality()).build());
        assertEquals(id, savedVet.getId());
    }

    @Test
    void saveNoId(){
        Vet savedVet = vetMapService.save(Vet.builder().specialities(prepareSpeciality()).build());
        assertNotNull(savedVet);
        assertNotNull(savedVet.getId());
    }

    @Test
    void findById() {
        Vet vet = vetMapService.findById(vetId);
        assertEquals(vetId, vet.getId());
    }
}
