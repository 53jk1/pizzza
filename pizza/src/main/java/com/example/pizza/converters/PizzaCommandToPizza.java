package com.example.muslibry5k.converters;


import com.example.pizza.commands.PizzaCommand;
import com.example.pizza.model.Pizza;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PizzaCommandToPizza implements Converter<PizzaCommand, Pizza> {

    @Synchronized
    @Nullable
    @Override
    public Pizza convert(PizzaCommand source) {
        if (source == null) {
            return null;
        }

        final Pizza pizza = new Pizza();
        pizza.setFirstName(source.getFirstName());
        pizza.setNumber(source.getNumber());


        return pizza;
    }
}