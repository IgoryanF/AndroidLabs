package com.renthut.myapplication;


import java.io.Serializable;

public class Product implements Serializable {
    private String type;
    private String name;
    private String description;
    private String status;
    private int price;
    private double weight;
    private String material;
    private int photo;

    public Product() {
    }

    public Product(String type, String name, String description, String status, int price, double weight, String material, int photo) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.status = status;
        this.price = price;
        this.weight = weight;
        this.material = material;
        this.photo = photo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
