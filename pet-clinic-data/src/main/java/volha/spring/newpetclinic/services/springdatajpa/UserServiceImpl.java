package volha.spring.newpetclinic.services.springdatajpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import volha.spring.newpetclinic.model.Role;
import volha.spring.newpetclinic.model.Status;
import volha.spring.newpetclinic.model.User;
import volha.spring.newpetclinic.repositories.RoleRepository;
import volha.spring.newpetclinic.repositories.UserRepository;
import volha.spring.newpetclinic.services.UserService;

import java.util.ArrayList;
import java.util.List;

/*
 *Created by olga on 03.09.2020
 */
@Service
@Profile("springdatajpa")
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        User registerUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registerUser);
        return registerUser ;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = (List<User>) userRepository.findAll();
        log.info("In getAll {} users were found" , userList.size());
        return userList;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        if(result == null){
            log.warn("In findByUsername - no user found by username {}", username);
            return null;
        }
        log.info("In findByUsername - user: {} found", result);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);
        if(result == null){
            log.warn("In findById - no user found by id {}", id);
            return null;
        }
        log.info("In findById - user: {} found", result);
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("In delete - user with id ; {} successfully deleted", id);
    }
}
