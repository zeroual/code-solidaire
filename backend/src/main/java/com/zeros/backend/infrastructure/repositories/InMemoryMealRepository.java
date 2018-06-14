package com.zeros.backend.infrastructure.repositories;

import com.zeros.backend.domain.models.Meal;
import com.zeros.backend.domain.repositories.MealRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryMealRepository extends AbstractInMemoryRepository<Meal> implements MealRepository {
}
