package volha.spring.newpetclinic.services;

import volha.spring.newpetclinic.model.Pet;

import java.util.Set;

/*
 *Created by olga on 15.04.2020
 */
public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
