package com.springframework.petcare.repositories;

import com.springframework.petcare.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
