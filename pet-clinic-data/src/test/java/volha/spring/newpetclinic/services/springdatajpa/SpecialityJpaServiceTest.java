package volha.spring.newpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import volha.spring.newpetclinic.model.Speciality;
import volha.spring.newpetclinic.repositories.SpecialityRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SpecialityJpaServiceTest {

    @Mock
    SpecialityRepository specialityRepository;

    @InjectMocks
    SpecialityJpaService service;

    Speciality returnSpec;

    @BeforeEach
    void setUp() {
        returnSpec = Speciality.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<Speciality> returnSet = new HashSet<>();
        returnSet.add(Speciality.builder().id(1L).build());
        returnSet.add(Speciality.builder().id(2L).build());

        when(specialityRepository.findAll()).thenReturn(returnSet);

        Set<Speciality> specialitySet = service.findAll();
        assertNotNull(specialitySet);
        assertEquals(2, specialitySet.size());
    }

    @Test
    void findById() {
        when(specialityRepository.findById(anyLong())).thenReturn(Optional.of(returnSpec));
        Speciality spec = service.findById(1L);
        assertNotNull(spec);
        assertEquals(1, spec.getId());
        verify(specialityRepository).findById(anyLong());
    }

    @Test
    void findByidNotNull(){
        when(specialityRepository.findById(anyLong())).thenReturn(Optional.empty());
        Speciality spec =service.findById(1L);
        assertNull(spec);
    }

    @Test
    void save() {
            Speciality specToSave = Speciality.builder().id(1L).build();
            when(specialityRepository.save(any())).thenReturn(returnSpec);
            Speciality savedSpec = service.save(specToSave);
            assertNotNull(savedSpec);
            assertEquals(1, savedSpec.getId());
            verify(specialityRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnSpec);
        verify(specialityRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(specialityRepository).deleteById(anyLong());
    }
}
