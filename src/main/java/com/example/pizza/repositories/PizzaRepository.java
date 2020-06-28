package com.example.pizza.repositories;

import com.example.pizza.model.Pizza;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PizzaRepository  extends CrudRepository<Pizza, Long> {
    Optional<Pizza> getFirstByFirstNameAndNumber(String firstName, String number);

    Optional<Pizza> getFirstByFirstName(String firstName);
}