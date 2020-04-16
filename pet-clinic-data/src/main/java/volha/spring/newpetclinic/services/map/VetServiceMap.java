package volha.spring.newpetclinic.services.map;

import org.springframework.stereotype.Service;
import volha.spring.newpetclinic.model.Vet;
import volha.spring.newpetclinic.services.VetService;

import java.util.Set;

/*
 *Created by olga on 15.04.2020
 */
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
