package volha.spring.newpetclinic.security.jwt;


import org.springframework.security.core.AuthenticationException;

/*
 *Created by olga on 03.09.2020
 */
public class JwtAuthenticationException extends AuthenticationException {
    public JwtAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }
}
