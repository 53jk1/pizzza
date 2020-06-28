package com.example.pizza.commands;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SizeCommand {
    private Long id;
    private Long size;
    private String price;

    public SizeCommand() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public SizeCommand(Long id, Long size, String price) {
        this.id = id;
        this.size = size;
        this.price = price;
    }
}
