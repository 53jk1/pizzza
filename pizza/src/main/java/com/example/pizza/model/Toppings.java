package com.example.pizza.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Toppings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sauce;
    private String dough;
    private String toppings1;
    private String toppings2;

    public Toppings() {

    }

    @Override
    public String toString() {
        return "Toppings{" +
                "id=" + id +
                ", sauce='" + sauce + '\'' +
                ", dough='" + dough + '\'' +
                ", toppings1='" + toppings1 + '\'' +
                ", toppings2='" + toppings2 + '\'' +
                ", size=" + size +
                ", pizzas=" + pizzas +
                '}';
    }

    public Toppings(Long id, String sauce, String dough, String toppings1, String toppings2, Size size) {
        this.id = id;
        this.sauce = sauce;
        this.dough = dough;
        this.toppings1 = toppings1;
        this.toppings2 = toppings2;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public String getSauce() {
        return sauce;
    }

    public String getDough() {
        return dough;
    }

    public String getToppings1() {
        return toppings1;
    }

    public String getToppings2() {
        return toppings2;
    }

    public Size getSize() {
        return size;
    }

    public Set<Pizza> getPizzas() {
        return pizzas;
    }

    @ManyToOne
    private Size size;

    @ManyToMany
    private final Set<Pizza> pizzas = new HashSet<>();

    public Toppings(String sauce, String dough, String toppings1, String toppings2, Size size) {
        this.sauce = sauce;
        this.dough = dough;
        this.toppings1 = toppings1;
        this.toppings2 = toppings2;
        this.size = size;
    }

    public Toppings(String sauce, String dough, String toppings1, String toppings2) {
        this.sauce = sauce;
        this.dough = dough;
        this.toppings1 = toppings1;
        this.toppings2 = toppings2;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSize(com.example.pizza.model.Size size) {
        this.size = size;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setToppings1(String toppings1) {
        this.toppings1 = toppings1;
    }

    public void setToppings2(String toppings2) {
        this.toppings2 = toppings2;
    }
}