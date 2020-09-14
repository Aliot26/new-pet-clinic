package volha.spring.newpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import volha.spring.newpetclinic.model.User;

/*
 *Created by olga on 13.09.2020
 */
public interface UserRepository  extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
