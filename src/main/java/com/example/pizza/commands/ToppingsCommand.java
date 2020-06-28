package com.example.pizza.commands;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ToppingsCommand {
    private Long id;
    private String sauce;
    private String dough;
    private String toppings1;
    private String toppings2;
    private Long sizeId;
    private Long pizzaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getToppings1() {
        return toppings1;
    }

    public void setToppings1(String toppings1) {
        this.toppings1 = toppings1;
    }

    public String getToppings2() {
        return toppings2;
    }

    public void setToppings2(String toppings2) {
        this.toppings2 = toppings2;
    }

    public Long getSizeId() {
        return sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
    }

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }
}