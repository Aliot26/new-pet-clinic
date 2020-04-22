package volha.spring.newpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import volha.spring.newpetclinic.model.Visit;

/*
 *Created by olga on 22.04.2020
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
