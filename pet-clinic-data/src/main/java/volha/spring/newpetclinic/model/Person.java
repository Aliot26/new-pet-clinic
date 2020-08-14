package volha.spring.newpetclinic.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/*
 *Created by olga on 13.04.2020
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @ApiModelProperty(value = "This is owner's first name", required = true)
    @Column(name = "first_name")
    private String firstName;

    @ApiModelProperty(value = "This is owner's last name", required = true)
    @Column(name = "last_name")
    private String lastName;
}
