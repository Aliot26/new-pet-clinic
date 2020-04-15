package volha.spring.newpetclinic.services;

import volha.spring.newpetclinic.model.Owner;

import java.util.Set;

/*
 *Created by olga on 15.04.2020
 */
public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
