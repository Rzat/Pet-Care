package com.springframework.petcare.repositories;

import com.springframework.petcare.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
