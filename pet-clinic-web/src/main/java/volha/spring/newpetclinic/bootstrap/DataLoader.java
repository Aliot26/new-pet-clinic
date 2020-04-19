package volha.spring.newpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import volha.spring.newpetclinic.model.Owner;
import volha.spring.newpetclinic.model.Pet;
import volha.spring.newpetclinic.model.PetType;
import volha.spring.newpetclinic.model.Vet;
import volha.spring.newpetclinic.services.OwnerService;
import volha.spring.newpetclinic.services.PetTypeService;
import volha.spring.newpetclinic.services.VetService;

import java.time.LocalDate;

/*
 *Created by olga on 16.04.2020
 */
@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private  final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName(("Weston"));
        owner1.setAddress("Zlota 20");
        owner1.setCity("Warsaw");
        owner1.setTelephone("1234566");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Jekkie");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Black");
        owner2.setAddress("Zelazna 2");
        owner2.setCity("Warsaw");
        owner2.setTelephone("7234522");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Jerry");
        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Alex");
        vet1.setLastName("Norman");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Diana");
        vet2.setLastName("Axe");

        vetService.save(vet2);

        System.out.println("Loaded vets....");
    }
}
