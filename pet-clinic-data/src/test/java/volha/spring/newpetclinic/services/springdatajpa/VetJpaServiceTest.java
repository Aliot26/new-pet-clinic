package volha.spring.newpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import volha.spring.newpetclinic.model.Vet;
import volha.spring.newpetclinic.repositories.VetRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VetJpaServiceTest {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetJpaService service;

    Vet returnVet;

    @BeforeEach
    void setUp() {
        returnVet = Vet.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<Vet> returnSet = new HashSet<>();
        returnSet.add(Vet.builder().id(1l).build());
        returnSet.add(Vet.builder().id(2l).build());
        when(vetRepository.findAll()).thenReturn(returnSet);
        Set<Vet> vets = service.findAll();
        assertNotNull(vets);
        assertEquals(2, vets.size());
    }

    @Test
    void findById() {
        when(vetRepository.findById(anyLong())).thenReturn(Optional.of(returnVet));
        Vet vet = service.findById(1L);
        assertNotNull(vet);
        assertEquals(1, vet.getId());
    }

    @Test
    void finfByIdNotFound(){
        when(vetRepository.findById(anyLong())).thenReturn(Optional.empty());
        Vet vet = service.findById(1L);
        assertNull(vet);
    }

    @Test
    void save() {
        Vet vetToSave = Vet.builder().id(1L).build();
        when(vetRepository.save(any())).thenReturn(returnVet);
        Vet vetSaved = service.save(vetToSave);
        assertNotNull(vetSaved);
        assertEquals(1, vetSaved.getId());
        verify(vetRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnVet);
        verify(vetRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(vetRepository).deleteById(anyLong());
    }
}
