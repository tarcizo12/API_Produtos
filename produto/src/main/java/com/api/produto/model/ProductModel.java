package com.api.produto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class ProductModel {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "code")
    private int code;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private double value;

    //Get e setters
    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
