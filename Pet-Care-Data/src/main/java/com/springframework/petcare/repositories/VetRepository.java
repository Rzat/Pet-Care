package com.springframework.petcare.repositories;

import com.springframework.petcare.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
