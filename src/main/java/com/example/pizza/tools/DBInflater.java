package com.example.pizza.tools;

import com.example.pizza.model.Pizza;
import com.example.pizza.model.Size;
import com.example.pizza.model.Toppings;
import com.example.pizza.repositories.PizzaRepository;
import com.example.pizza.repositories.SizeRepository;
import com.example.pizza.repositories.ToppingsRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    public DBInflater(ToppingsRepository toppingsRepository, PizzaRepository pizzaRepository, SizeRepository sizeRepository) {
        this.toppingsRepository = toppingsRepository;
        this.pizzaRepository = pizzaRepository;
        this.sizeRepository = sizeRepository;
    }

    private ToppingsRepository toppingsRepository;
    private PizzaRepository pizzaRepository;
    private SizeRepository sizeRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
    }
}
