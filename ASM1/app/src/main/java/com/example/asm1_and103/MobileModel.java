package com.example.asm1_and103;

public class MobileModel {
    private String id;
    private String name;
    private int born;
    private String brand;
    private double price;
    private String image; // Thêm thuộc tính này

    public MobileModel(String id, String name, int born, String brand, double price, String image) {
        this.id = id;
        this.name = name;
        this.born = born;
        this.brand = brand;
        this.price = price;
        this.image = image; // Thêm thuộc tính này
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBorn() {
        return born;
    }

    public void setBorn(int born) {
        this.born = born;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() { // Thêm getter này
        return image;
    }

    public void setImage(String image) { // Thêm setter này
        this.image = image;
    }

    public MobileModel() {
    }
}
