package com.example.EcommerceApp.DAO;

public class ProductDO {
    private String name;
    private double price;
    private String description;
    private Long categoryId;
    private int quantity;
    private double weight;

    public ProductDO() {
    }

    public ProductDO(String name, double price, Long categoryId, String description, int quantity, double weight) {
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.description = description;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
