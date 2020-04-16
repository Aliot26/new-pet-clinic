package volha.spring.newpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import volha.spring.newpetclinic.model.Owner;
import volha.spring.newpetclinic.model.Vet;
import volha.spring.newpetclinic.services.OwnerService;
import volha.spring.newpetclinic.services.VetService;

/*
 *Created by olga on 16.04.2020
 */
@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName(("Weston"));

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Black");

        ownerService.save(owner2);

        System.out.println("Loaded owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Alex");
        vet1.setLastName("Norman");

        vetService.save(vet1);
//        System.out.println(vet1.getFirstName());

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Diana");
        vet2.setLastName("Axe");

        vetService.save(vet2);

        System.out.println("Loaded vets....");
    }
}
