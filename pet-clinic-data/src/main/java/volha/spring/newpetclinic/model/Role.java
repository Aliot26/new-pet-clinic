package volha.spring.newpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/*
 *Created by olga on 10.09.2020
 */
@Entity
@Table(name = "roles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;
}
