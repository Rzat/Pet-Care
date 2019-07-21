package com.springframework.petcare.bootstrap;

import com.springframework.petcare.model.Owner;
import com.springframework.petcare.model.Pet;
import com.springframework.petcare.model.PetType;
import com.springframework.petcare.model.Vet;
import com.springframework.petcare.services.OwnerService;
import com.springframework.petcare.services.PetTypeService;
import com.springframework.petcare.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.logging.Logger;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger logger = Logger.getLogger(DataLoader.class.getName());
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;

    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog); //later to use with owner and vets.


        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat); //later to use with owner and vets.

        logger.info("Loading PetType");

        Owner owner = new Owner();
        owner.setFirstName("Rajat");
        owner.setLastName("Thakur");
        owner.setAddress("Kormangala, 3rd block");
        owner.setCity("Bangalore");
        owner.setTelephone("9988776655");

        Pet myPet = new Pet();
        myPet.setPetType(dog);
        myPet.setOwner(owner);
        myPet.setName("java");
        myPet.setBirthDate(LocalDate.now());
        owner.getPets().add(myPet);

        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Rajat2");
        owner2.setLastName("Thakur2");
        owner2.setAddress("Kormangala, 4th block");
        owner2.setCity("Bangalore");
        owner2.setTelephone("3322116655");

        Pet yoursPet = new Pet();
        yoursPet.setPetType(cat);
        yoursPet.setOwner(owner2);
        yoursPet.setBirthDate(LocalDate.now());
        yoursPet.setName("Mili");
        owner2.getPets().add(yoursPet);

        ownerService.save(owner2);

        logger.info("Loading Owners");

        Vet vet = new Vet();
        vet.setFirstName("vetRajat");
        vet.setLastName("vetThakur");

        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("vetRajat2");
        vet2.setLastName("vetThakur2");

        vetService.save(vet2);


        logger.info("Loading Vets");


    }
}

