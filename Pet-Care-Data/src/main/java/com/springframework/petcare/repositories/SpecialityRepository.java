package com.springframework.petcare.repositories;

import com.springframework.petcare.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
