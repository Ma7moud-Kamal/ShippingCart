package org.example.model;

public class Product {
    private final int id;
    private final String name;
    private final String description;
    private final int price;
    private int quantity;
    private int quantityInCart ;

    public Product(int id, String name, String disc, int price, int quantity) {
        this.id = id ;
        this.name = name;
        this.description = disc;
        this.price = price;
        this.quantity = quantity;
        this.quantityInCart = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    public int getQuantityInCart() {
        return quantityInCart;
    }
    public void setQuantity(int quantity) {
        this.quantity =quantity ;
    }
    public void setQuantityInCart(int quantityInCart) {
        this.quantityInCart = quantityInCart;
    }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', description='%s', price=%d, quantity=%d, quantityInCart=%d}",
                id, name, description, price, quantity, quantityInCart);
    }
}
