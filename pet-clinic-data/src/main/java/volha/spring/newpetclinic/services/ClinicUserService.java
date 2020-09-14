package volha.spring.newpetclinic.services;

import volha.spring.newpetclinic.model.User;

/*
 *Created by olga on 13.09.2020
 */
public interface ClinicUserService extends CrudService<User, Long> {
    User findByUsername(String username);
}
