package volha.spring.newpetclinic.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import volha.spring.newpetclinic.model.Role;
import volha.spring.newpetclinic.model.Status;
import volha.spring.newpetclinic.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 *Created by olga on 03.09.2020
 */
public final class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(User user){
        return new JwtUser(user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getStatus().equals(Status.ACTIVE),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles()))
                );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles){
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
