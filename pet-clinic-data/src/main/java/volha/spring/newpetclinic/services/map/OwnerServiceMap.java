package volha.spring.newpetclinic.services.map;

import org.springframework.stereotype.Service;
import volha.spring.newpetclinic.model.Owner;
import volha.spring.newpetclinic.services.OwnerService;

import java.util.Set;

/*
 *Created by olga on 15.04.2020
 */
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService{
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
        super.delete(owner);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findByLastName(lastName);
    }
}
