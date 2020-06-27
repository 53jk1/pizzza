package com.example.pizza.model;

import com.example.pizza.model.Toppings;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Pizza {
    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", number='" + number + '\'' +
                ", toppings=" + toppings +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String number;

    @ManyToMany(mappedBy = "pizzas")
    private Set<Toppings> toppings = new HashSet<>();

    public Pizza() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<Toppings> getToppings() {
        return toppings;
    }

    public Pizza(Long id, String firstName, String number, Set<Toppings> toppings) {
        this.id = id;
        this.firstName = firstName;
        this.number = number;
        this.toppings = toppings;
    }

    public void setToppings(Set<Toppings> toppings) {
        this.toppings = toppings;
    }

    public Pizza(String firstName, String number) {
        this.firstName = firstName;
        this.number = number;
    }
}