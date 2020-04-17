package volha.spring.newpetclinic.model;

import java.util.Set;

/*
 *Created by olga on 13.04.2020
 */
public class Vet extends Person {
    private Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
