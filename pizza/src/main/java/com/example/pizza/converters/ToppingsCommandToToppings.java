package com.example.pizza.converters;

import com.example.pizza.commands.ToppingsCommand;
import com.example.pizza.model.Pizza;
import com.example.pizza.model.Toppings;
import com.example.pizza.repositories.PizzaRepository;
import com.example.pizza.repositories.SizeRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ToppingsCommandToToppings implements Converter<ToppingsCommand, Toppings> {

    private final SizeRepository sizeRepository;
    private final PizzaRepository pizzaRepository;

    public ToppingsCommandToToppings(SizeRepository sizeRepository, PizzaRepository pizzaRepository) {
        this.sizeRepository = sizeRepository;
        this.pizzaRepository = pizzaRepository;
    }

    @lombok.Synchronized
    @org.springframework.lang.Nullable
    @Override
    public Toppings convert(@javax.annotation.Nonnull ToppingsCommand source) {
        if (source == null) {
            return null;
        }

        final com.example.pizza.model.Toppings toppings = new com.example.pizza.model.Toppings();
        toppings.setId(source.getId());
        toppings.setSauce(source.getSauce());
        toppings.setDough(source.getDough());
        toppings.setToppings1(source.getToppings1());
        toppings.setToppings2(source.getToppings2());

        java.util.Optional<com.example.pizza.model.Size> size = sizeRepository.findById(source.getSizeId());

        if (size.isPresent()) {
            toppings.setSize(size.get());
        } else {
            toppings.setSize(sizeRepository.getSizeByNr("Unknown").get());
        }

        Optional<Pizza> pizza = pizzaRepository.findById(source.getPizzaId());

        if (pizza.isPresent()) {
            toppings.getPizzas().add(pizza.get());
        }

        return toppings;
    }
}
