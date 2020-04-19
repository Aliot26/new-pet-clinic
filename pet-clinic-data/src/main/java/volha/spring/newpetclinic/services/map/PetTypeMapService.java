package volha.spring.newpetclinic.services.map;

import org.springframework.stereotype.Service;
import volha.spring.newpetclinic.model.PetType;
import volha.spring.newpetclinic.services.PetTypeService;

import java.util.Set;

/*
 *Created by olga on 17.04.2020
 */
@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
