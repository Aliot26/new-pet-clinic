package volha.spring.newpetclinic.services;

import volha.spring.newpetclinic.model.Role;

/*
 *Created by olga on 11.09.2020
 */
public interface RoleService extends CrudService<Role, Long>  {
    Role findByName(String name);
}
