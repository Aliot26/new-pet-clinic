package volha.spring.newpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import volha.spring.newpetclinic.model.Visit;
import volha.spring.newpetclinic.repositories.VisitRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitJpaService service;

    Visit returnVisit;

    @BeforeEach
    void setUp() {
        returnVisit = Visit.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<Visit> returnVisitSet = new HashSet<>();
        returnVisitSet.add(Visit.builder().id(1L).build());
        returnVisitSet.add(Visit.builder().id(2L).build());
        when(visitRepository.findAll()).thenReturn(returnVisitSet);
        Set<Visit> visits = service.findAll();
        assertNotNull(visits);
        assertEquals(2, visits.size());
    }

    @Test
    void findById() {
        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(returnVisit));
        Visit visit = service.findById(1L);
        assertNotNull(visit);
        assertEquals(1, visit.getId());
        verify(visitRepository).findById(anyLong());
    }

    @Test
    void findByIdNotFound(){
        when(visitRepository.findById(anyLong())).thenReturn((Optional.empty()));
        Visit visit = service.findById(1L);
        assertNull(visit);
        verify(visitRepository).findById(anyLong());
    }

    @Test
    void save() {
        Visit visitToSave = Visit.builder().id(1L).build();
        when(visitRepository.save(any())).thenReturn(returnVisit);
        Visit savedVisit = service.save(visitToSave);
        assertNotNull(savedVisit);
        assertEquals(1, savedVisit.getId());
        verify(visitRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnVisit);
        verify(visitRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(visitRepository).deleteById(anyLong());
    }
}
