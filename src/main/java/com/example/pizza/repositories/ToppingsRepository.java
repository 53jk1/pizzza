package com.example.pizza.repositories;

import com.example.pizza.model.Pizza;
import com.example.pizza.model.Toppings;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ToppingsRepository extends CrudRepository<Toppings, Long> {

    List<Toppings> getAllByPizzaIsContaining(Pizza pizza);

    Optional<Toppings> getFirstBySauce(String sauce);
}

