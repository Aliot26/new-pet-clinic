package volha.spring.newpetclinic.services.map;

import org.springframework.stereotype.Service;
import volha.spring.newpetclinic.model.Pet;
import volha.spring.newpetclinic.services.PetService;

import java.util.Set;

/*
 *Created by olga on 15.04.2020
 */
@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
