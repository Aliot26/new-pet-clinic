package volha.spring.newpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 *Created by olga on 13.04.2020
 */
@Entity
@Table(name = "types")
public class PetType extends BaseEntity{
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
