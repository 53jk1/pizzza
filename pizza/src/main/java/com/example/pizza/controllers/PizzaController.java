package com.example.pizza.controllers;

import com.example.pizza.commands.PizzaCommand;
import com.example.pizza.model.Pizza;
import com.example.pizza.repositories.PizzaRepository;
import com.example.pizza.repositories.ToppingsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class PizzaController {

    private PizzaRepository pizzaRepository;
    private com.example.pizza.repositories.ToppingsRepository toppingsRepository;
    private com.example.muslibry5k.converters.PizzaCommandToPizza pizzaCommandToPizza;

    public PizzaController(PizzaRepository pizzaRepository, ToppingsRepository toppingsRepository) {
        this.pizzaRepository = pizzaRepository;
        this.toppingsRepository = toppingsRepository;
    }

    @RequestMapping(value = {"/pizzas", "/pizza/list"})
    public String getPizzas(Model model) {
        model.addAttribute("artists", pizzaRepository.findAll());
        return "pizza/list";
    }

    @RequestMapping("/pizza/{id}/toppings")
    public String getPizzaToppings(Model model, @PathVariable("id") Long id) {
        Optional<Pizza> pizza = pizzaRepository.findById(id);

        if (pizza.isPresent()) {
            model.addAttribute("toppings", toppingsRepository.getAllByPizzaIsContaining(pizza.get()));
            model.addAttribute("filter", "pizza: " + pizza.get().getFirstName() + " " + pizza.get().getNumber());
        } else {
            model.addAttribute("toppings", new ArrayList<>());
            model.addAttribute("filter", "pizza for this id doesn't exist");
        }

        return "toppings/list";
    }

    @RequestMapping("/pizza/{id}/show")
    public String getPizzaDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("artist", pizzaRepository.findById(id).get());
        return "pizza/show";
    }

    @RequestMapping("/pizza/{id}/delete")
    public String deletePizza(@PathVariable("id") Long id) {
        pizzaRepository.deleteById(id);
        return "redirect:/pizzas";
    }

    @GetMapping
    @RequestMapping("/pizza/new")
    public String newToppings(Model model){
        model.addAttribute("pizza", new PizzaCommand());
        return "pizza/addedit";
    }

    @PostMapping("pizza")
    public String saveOrUpdate(@ModelAttribute PizzaCommand command){

        Optional<Pizza> pizzaOptional = pizzaRepository.getFirstByFirstNameAndNumber(command.getFirstName(), command.getNumber());

        if (!pizzaOptional.isPresent()) {
            Pizza detachedPizza = pizzaCommandToPizza.convert(command);
            Pizza savedPizza = pizzaRepository.save(detachedPizza);
            return "redirect:/pizza/" + savedPizza.getId() + "/show";
        } else {
            System.out.println("Sorry, there's such pizza in db");
            return "redirect:/pizza/" + pizzaOptional.get().getId() + "/show";
        }
    }
}
