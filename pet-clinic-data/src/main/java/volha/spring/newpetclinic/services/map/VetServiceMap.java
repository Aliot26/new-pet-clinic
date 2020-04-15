package volha.spring.newpetclinic.services.map;

import volha.spring.newpetclinic.model.Vet;
import volha.spring.newpetclinic.services.CrudService;

import java.util.Set;

/*
 *Created by olga on 15.04.2020
 */
public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
    @Override
    public Set<Vet> findAll() {
        return null;
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
        return super.save(vet.getId(), vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
