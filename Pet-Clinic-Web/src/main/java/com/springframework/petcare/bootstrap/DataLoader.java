package com.springframework.petcare.bootstrap;

import com.springframework.petcare.model.Owner;
import com.springframework.petcare.model.Vet;
import com.springframework.petcare.services.OwnerService;
import com.springframework.petcare.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger logger = Logger.getLogger(DataLoader.class.getName());
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Rajat");
        owner.setLastName("Thakur");

        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Rajat2");
        owner2.setLastName("Thakur2");

        ownerService.save(owner2);

        logger.info("Loaded Owners");

        Vet vet = new Vet();
        vet.setId(3L);
        vet.setFirstName("vetRajat");
        vet.setLastName("vetThakur");

        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setId(3L);
        vet2.setFirstName("vetRajat2");
        vet2.setLastName("vetThakur2");

        vetService.save(vet2);


        logger.info("Loaded Vets");
    }
}

