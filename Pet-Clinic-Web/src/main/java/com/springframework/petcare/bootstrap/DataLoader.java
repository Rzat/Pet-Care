package com.springframework.petcare.bootstrap;

import com.springframework.petcare.model.*;
import com.springframework.petcare.services.*;
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
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
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

        Visit catVisit = new Visit();
        catVisit.setPet(yoursPet);
        catVisit.setDescription("Snezzy Kiti");
        catVisit.setLocalDate(LocalDate.now());
        visitService.save(catVisit);

        logger.info("Loading Visit");

        logger.info("Loading Owners");

        Speciality nutrition = new Speciality();
        nutrition.setDescription("nutrition");
        Speciality savedNutrition = specialtyService.save(nutrition);

        Speciality pathology = new Speciality();
        pathology.setDescription("pathology");
        Speciality savedPathology = specialtyService.save(pathology);

        Speciality canine = new Speciality();
        canine.setDescription("canine");
        Speciality savedCanine = specialtyService.save(canine);

        Vet vet = new Vet();
        vet.setFirstName("vetRajat");
        vet.setLastName("vetThakur");
        vet.getSpecialities().add(savedCanine);
        vetService.save(vet);


        Vet vet2 = new Vet();
        vet2.setFirstName("vetRajat2");
        vet2.setLastName("vetThakur2");
        vet2.getSpecialities().add(savedPathology);

        vetService.save(vet2);


        logger.info("Loading Vets");
    }
}

