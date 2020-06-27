package com.example.pizza.controllers;

import com.example.pizza.model.Size;
import com.example.pizza.repositories.SizeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SizeController{

    private SizeRepository sizeRepository;
    private com.example.pizza.converters.SizeCommandToSize sizeCommandToSize;

    public SizeController(SizeRepository sizeRepository, com.example.pizza.converters.SizeCommandToSize sizeCommandToSized) {
        this.sizeRepository = sizeRepository;
        this.sizeCommandToSize = sizeCommandToSize;
    }

    @RequestMapping(value = {"/sizes", "/sizes/list"})
    public String getSizes(Model model) {
        model.addAttribute("size", sizeRepository.findAll());
        return "size/list";
    }

    @RequestMapping("/size/{id}/show")
    public String getSizeDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("size", sizeRepository.findById(id).get());
        return "size/show";
    }

    @RequestMapping("/size/{id}/delete")
    public String deleteSize(@PathVariable("id") Long id) {
        sizeRepository.deleteById(id);
        return "redirect:/sizes";
    }

    @GetMapping
    @RequestMapping("/size/new")
    public String newSize(Model model){
        model.addAttribute("size", new com.example.pizza.commands.SizeCommand());
        return "size/addedit";
    }

    @PostMapping("size")
    public String saveOrUpdate(@ModelAttribute com.example.pizza.commands.SizeCommand command){

        Optional<Size> sizeOptional = sizeRepository.getSizeByNr(command.getSize());

        if (!sizeOptional.isPresent()) {
            Size detachedSize = sizeCommandToSize.convert(command);
            Size savedSize = sizeRepository.save(detachedSize);
            return "redirect:/size/" + savedSize.getId() + "/show";
        } else {
            System.out.println("Sorry, there's such size in db");
            return "redirect:/size/" + sizeOptional.get().getId() + "/show";
        }
    }
}
