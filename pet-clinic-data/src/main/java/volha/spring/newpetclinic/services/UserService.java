package volha.spring.newpetclinic.services;

import volha.spring.newpetclinic.model.User;

import java.util.List;

/*
 *Created by olga on 02.09.2020
 */
public interface UserService {
    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}
