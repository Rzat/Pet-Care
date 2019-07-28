package com.springframework.petcare.repositories;

import com.springframework.petcare.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
