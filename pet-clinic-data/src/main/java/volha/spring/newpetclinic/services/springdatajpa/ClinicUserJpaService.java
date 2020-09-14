package volha.spring.newpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import volha.spring.newpetclinic.model.User;
import volha.spring.newpetclinic.repositories.UserRepository;
import volha.spring.newpetclinic.services.ClinicUserService;

import java.util.HashSet;
import java.util.Set;

/*
 *Created by olga on 13.09.2020
 */
@Service
@Profile("springdatajpa")
public class ClinicUserJpaService implements ClinicUserService {
    private final UserRepository userRepository;

    public ClinicUserJpaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User findById(Long aLong) {
        return userRepository.findById(aLong).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }
}
