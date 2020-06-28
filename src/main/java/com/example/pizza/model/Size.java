package com.example.pizza.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long size;
    private String price;

    public Size() {
    }
    public Size(Long size) {
        this.size = size;
    }

    public Size(Long size, String price) {
        this.size = size;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                '}';
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
}