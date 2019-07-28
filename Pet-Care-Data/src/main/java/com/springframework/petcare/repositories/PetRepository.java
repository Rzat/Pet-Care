package com.springframework.petcare.repositories;

import com.springframework.petcare.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
