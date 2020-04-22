package volha.spring.newpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import volha.spring.newpetclinic.model.Vet;
import volha.spring.newpetclinic.repositories.VetRepository;
import volha.spring.newpetclinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

/*
 *Created by olga on 22.04.2020
 */
@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService {
    private final VetRepository vetRepository;

    public VetJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet>vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
