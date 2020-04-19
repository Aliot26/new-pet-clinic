package volha.spring.newpetclinic.services.map;

import org.springframework.stereotype.Service;
import volha.spring.newpetclinic.model.Speciality;
import volha.spring.newpetclinic.services.SpecialityService;

import java.util.Set;

/*
 *Created by olga on 19.04.2020
 */
@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return null;
    }
}
