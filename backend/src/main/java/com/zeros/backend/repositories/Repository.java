package com.zeros.backend.repositories;

import com.zeros.backend.models.Entity;

public interface Repository<T extends Entity> {

    T findOne(Long id);

    T save(T entity);

    Iterable<T> findAll();

    void deleteAll();

    boolean exists(Long id);

    long count();
}
