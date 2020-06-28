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

        Pizza margarita = new Pizza("Margarita", "1");
        Size medium3 = new Size("32");
        Toppings two3 = new Toppings("tomato", "SAN FRANCISCO STYLE", "---",
                "---", medium3);
        margarita.getToppings().add(two3);
        two3.getPizzas().add(margarita);
        sizeRepository.save(medium3);
        pizzaRepository.save(margarita);
        toppingsRepository.save(two3);


        Pizza classic = new Pizza("Classic", "2");
        Size medium = new Size("32");
        Toppings two1 = new Toppings("tomato", "SAN FRANCISCO STYLE", "ham",
                "mushrooms", medium);
        classic.getToppings().add(two1);
        two1.getPizzas().add(classic);
        sizeRepository.save(medium);
        pizzaRepository.save(classic);
        toppingsRepository.save(two1);


        Pizza americana = new Pizza("Americana", "3");
        Size medium2 = new Size("32");
        Toppings two2 = new Toppings("tomato", "SAN FRANCISCO STYLE", "cherry tomatoes",
                "mushrooms", medium2);
        americana.getToppings().add(two2);
        two2.getPizzas().add(americana);
        sizeRepository.save(medium2);
        pizzaRepository.save(americana);
        toppingsRepository.save(two2);


    }
}
