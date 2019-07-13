package com.springframework.petcare.services;

import com.springframework.petcare.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
