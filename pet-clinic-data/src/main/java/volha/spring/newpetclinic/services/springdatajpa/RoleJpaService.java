package volha.spring.newpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import volha.spring.newpetclinic.model.Role;
import volha.spring.newpetclinic.repositories.RoleRepository;
import volha.spring.newpetclinic.services.RoleService;

import java.util.HashSet;
import java.util.Set;

/*
 *Created by olga on 11.09.2020
 */
@Service
@Profile("springdatajpa")
public class RoleJpaService implements RoleService{
    private final RoleRepository roleRepository;

    public RoleJpaService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> findAll() {
        Set<Role> roles = new HashSet<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    @Override
    public Role findById(Long aLong) {
        return roleRepository.findById(aLong).orElse(null);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public void deleteById(Long aLong) {
        roleRepository.deleteById(aLong);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
