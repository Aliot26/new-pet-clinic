package volha.spring.newpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import volha.spring.newpetclinic.model.PetType;
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
class PetTypeJpaServiceTest {
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    PetTypeJpaService service;

    PetType returnType;

    @BeforeEach
    void setUp() {
        returnType = PetType.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<PetType> returnTypeSet = new HashSet<>();
        returnTypeSet.add(PetType.builder().id(1L).build());
        returnTypeSet.add(PetType.builder().id(2L).build());

        when(petTypeRepository.findAll()).thenReturn(returnTypeSet);

        Set<PetType> types = service.findAll();
        assertNotNull(types);
        assertEquals(2, types.size());
    }

    @Test
    void findById() {
        when(petTypeRepository.findById(anyLong())).thenReturn(Optional.of(returnType));
        PetType type = service.findById(1L);
        assertNotNull(type);
        assertEquals(1, type.getId());
    }

    @Test
    void findByIdNotFound(){
        when(petTypeRepository.findById(anyLong())).thenReturn(Optional.empty());
        PetType type = service.findById(1L);
        assertNull(type);
    }

    @Test
    void save() {
        PetType typeToSave = PetType.builder().id(1l).build();
        when(petTypeRepository.save(any())).thenReturn(returnType);
        PetType savedType = service.save(typeToSave);
        assertNotNull(savedType);
        assertEquals(1, savedType.getId());
        verify(petTypeRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnType);
        verify(petTypeRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(petTypeRepository).deleteById(anyLong());
    }
}
