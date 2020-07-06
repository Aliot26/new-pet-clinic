package volha.spring.newpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import volha.spring.newpetclinic.model.PetType;
import volha.spring.newpetclinic.model.Speciality;
import volha.spring.newpetclinic.services.PetTypeService;
import volha.spring.newpetclinic.services.SpecialityService;

/*
 *Created by olga on 16.04.2020
 */
@Component
public class DataLoader implements CommandLineRunner {
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(PetTypeService petTypeService, SpecialityService specialityService) {

        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }


    @Override
    public void run(String... args) throws Exception {
        int countTypes = petTypeService.findAll().size();
        if (countTypes == 0) {
            loadTypes();
        }

        int countSpecialities = specialityService.findAll().size();
        if (countSpecialities == 0) {
            loadSpecialities();
        }
    }

    private void loadSpecialities() {
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


    }

    private void loadTypes() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);
    }
}
