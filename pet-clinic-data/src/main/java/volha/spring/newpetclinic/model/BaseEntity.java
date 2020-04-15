package volha.spring.newpetclinic.model;

import java.io.Serializable;

/*
 *Created by olga on 15.04.2020
 */
public class BaseEntity implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
