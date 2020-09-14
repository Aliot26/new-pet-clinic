package volha.spring.newpetclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *Created by olga on 08.09.2020
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequestDto {
    private String username;
    private  String password;

}
