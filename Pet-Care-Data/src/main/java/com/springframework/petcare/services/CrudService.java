package com.springframework.petcare.services;

import java.util.Set;

public interface CrudService<T, ID> {
    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void deleteById(ID id);

    void delete(T object);
}
