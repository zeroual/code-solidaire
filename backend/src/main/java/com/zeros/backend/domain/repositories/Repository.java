package com.zeros.backend.domain.repositories;

import com.zeros.backend.domain.models.Entity;

public interface Repository<T extends Entity> {

    T findOne(Long id);

    T save(T entity);

    Iterable<T> findAll();

    void deleteAll();

    boolean exists(Long id);

    long count();
}
