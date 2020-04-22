package volha.spring.newpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import volha.spring.newpetclinic.model.PetType;

/*
 *Created by olga on 22.04.2020
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
