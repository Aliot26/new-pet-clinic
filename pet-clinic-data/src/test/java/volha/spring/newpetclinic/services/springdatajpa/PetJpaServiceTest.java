package volha.spring.newpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import volha.spring.newpetclinic.model.Owner;
import volha.spring.newpetclinic.model.Pet;
import volha.spring.newpetclinic.model.PetType;
import volha.spring.newpetclinic.repositories.PetRepository;
import volha.spring.newpetclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetJpaServiceTest {

    @Mock
    PetTypeRepository petTypeRepository;

    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetJpaService service;

    Pet returnPet;
    Owner owner;
    PetType petType;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).build();
        petType = PetType.builder().id(1L).build();
        returnPet = Pet.builder().id(1L).owner(owner).petType(petType).build();
    }

    @Test
    void findAll() {
        Set<Pet> returnPetSet = new HashSet<>();
        returnPetSet.add(Pet.builder().id(1L).petType(petType).owner(owner).build());
        returnPetSet.add(Pet.builder().id(2L).petType(petType).owner(owner).build());

        when(petRepository.findAll()).thenReturn(returnPetSet);

        Set<Pet> pets = service.findAll();
        assertNotNull(pets);
        assertEquals(2, pets.size());
    }

    @Test
    void findById() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.of(returnPet));
        Pet pet = service.findById(1L);
        assertNotNull(pet);
        assertEquals(1, owner.getId());
    }

    @Test
    void findByIdNotFound(){
        when(petRepository.findById(anyLong())).thenReturn(Optional.empty());
        Pet pet = service.findById(1L);
        assertNull(pet);
    }

    @Test
    void save() {
        Pet petToSave = Pet.builder().id(1L).build();
        when(petRepository.save(any())).thenReturn(returnPet);
        Pet petSaved = service.save(petToSave);
        assertNotNull(petSaved);
        verify(petRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnPet);
        verify(petRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(petRepository).deleteById(anyLong());
    }
}
