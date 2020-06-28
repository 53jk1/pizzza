package com.example.pizza.controllers;

import com.example.pizza.commands.ToppingsCommand;
import com.example.pizza.converters.ToppingsCommandToToppings;
import com.example.pizza.model.Toppings;
import com.example.pizza.repositories.PizzaRepository;
import com.example.pizza.repositories.SizeRepository;
import com.example.pizza.repositories.ToppingsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ToppingsController {

    private ToppingsRepository toppingsRepository;
    private com.example.pizza.converters.ToppingsCommandToToppings toppingsCommandToToppings;
    private SizeRepository sizeRepository;
    private PizzaRepository pizzaRepository;

    public ToppingsController(ToppingsRepository toppingsRepository, ToppingsCommandToToppings toppingsCommandToToppings, SizeRepository sizeRepository, PizzaRepository pizzaRepository) {
        this.toppingsRepository = toppingsRepository;
        this.toppingsCommandToToppings = toppingsCommandToToppings;
        this.sizeRepository = sizeRepository;
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping
    @RequestMapping(value = {"/toppings" , "toppings/list"})
    public String getToppings(Model model) {
        model.addAttribute("toppings", toppingsRepository.findAll());
        return "toppings/list";
    }

    @GetMapping
    @RequestMapping("/toppings/{id}/show")
    public String getToppingsDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("toppings", toppingsRepository.findById(id).get());
        return "toppings/show";
    }

    @GetMapping
    @RequestMapping("/toppings/{id}/delete")
    public String deleteToppigns(@PathVariable("id") Long id) {
        toppingsRepository.deleteById(id);
        return "redirect:/toppings";
    }

    @GetMapping
    @RequestMapping("/toppings/new")
    public String newToppings(Model model){
        model.addAttribute("toppings", new ToppingsCommand());
        model.addAttribute("size", sizeRepository.findAll());
        model.addAttribute("pizza", pizzaRepository.findAll());
        return "toppings/addedit";
    }

    @PostMapping("song")
    public String saveOrUpdate(@ModelAttribute ToppingsCommand command){
        Toppings detachedToppings = toppingsCommandToToppings.convert(command);
        Toppings savedToppings = toppingsRepository.save(detachedToppings);

        return "redirect:/toppings/" + savedToppings.getId() + "/show";
    }
}
