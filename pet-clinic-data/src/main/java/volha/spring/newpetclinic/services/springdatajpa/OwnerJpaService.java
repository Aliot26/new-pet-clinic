package volha.spring.newpetclinic.services.springdatajpa;

import org.springframework.stereotype.Service;
import volha.spring.newpetclinic.model.Owner;
import volha.spring.newpetclinic.repositories.OwnerRepository;
import volha.spring.newpetclinic.repositories.PetRepository;
import volha.spring.newpetclinic.repositories.PetTypeRepository;
import volha.spring.newpetclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

/*
 *Created by olga on 22.04.2020
 */
@Service
public class OwnerJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {

        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
