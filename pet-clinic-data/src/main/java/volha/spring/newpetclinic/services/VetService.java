package volha.spring.newpetclinic.services;

import volha.spring.newpetclinic.model.Vet;

import java.util.Set;

/*
 *Created by olga on 15.04.2020
 */
public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
