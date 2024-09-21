package org.example.shopping.items;

import org.example.model.Product;
import org.example.services.impl.ProductImpl;

import java.util.List;
import java.util.Scanner;

public interface CartServices {
    public void createProducts(List<Product> products);
    void displayCartMethods(Scanner scanner,List<Product>products, ProductImpl productMethods);
    void displayMethodFromUser(int numberFromUser, List<Product>products, ProductImpl productMethods, Scanner scanner);
    void viewCart();
    void addProductByID(List<Product>productList, int id);
    void updateQuantity(int id);
    void removeProduct(int id);
    void printInColor(String name, int quantityBefore, int quantityAfter);
}
