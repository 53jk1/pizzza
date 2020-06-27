package com.example.pizza.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class SizeCommand {
    private Long id;
    private String size;
    private String price;

    public SizeCommand() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public SizeCommand(Long id, String size, String price) {
        this.id = id;
        this.size = size;
        this.price = price;
    }
}
