package volha.spring.newpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 *Created by olga on 17.04.2020
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity {
    @Column(name = "description")
    private String description;

    @Builder
    public  Speciality(Long id, String description){
        super(id);
        this.description = description;
    }
}
