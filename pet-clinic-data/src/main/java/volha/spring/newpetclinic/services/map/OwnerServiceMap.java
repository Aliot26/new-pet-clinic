package volha.spring.newpetclinic.services.map;

import volha.spring.newpetclinic.model.Owner;
import volha.spring.newpetclinic.services.CrudService;

import java.util.Set;

/*
 *Created by olga on 15.04.2020
 */
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        this.delete(owner);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public Owner findById(Long id) {
        return this.findById(id);
    }
}
