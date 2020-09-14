package volha.spring.newpetclinic.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import volha.spring.newpetclinic.model.User;
import volha.spring.newpetclinic.security.jwt.JwtUser;
import volha.spring.newpetclinic.security.jwt.JwtUserFactory;
import volha.spring.newpetclinic.services.UserService;

/*
 *Created by olga on 03.09.2020
 */
@Service("details")
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User with username " + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("In loadUserByName user with username {} successfully loaded", username);
        return jwtUser;
    }
}
