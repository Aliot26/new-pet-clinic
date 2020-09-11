package volha.spring.newpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import volha.spring.newpetclinic.model.Role;

/*
 *Created by olga on 11.09.2020
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
