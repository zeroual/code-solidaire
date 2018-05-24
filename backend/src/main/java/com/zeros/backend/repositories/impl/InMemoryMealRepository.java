package com.zeros.backend.repositories.impl;

import com.zeros.backend.models.Meal;
import com.zeros.backend.repositories.MealRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryMealRepository extends AbstractInMemoryRepository<Meal> implements MealRepository {
}
