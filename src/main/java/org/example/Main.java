package org.example;

import org.example.ansi.ANSIColors;
import org.example.model.Product;
import org.example.services.impl.ProductImpl;
import org.example.shopping.items.CartImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductImpl productMethods = new ProductImpl();
        List<Product> products = new ArrayList<>();
        CartImpl cart = new CartImpl();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome to our online store!");
        cart.createProducts(products);
        System.out.println("We have the following products in our store:\n");
        productMethods.viewProducts(products);
        System.out.println("\nDo u want to search by category");
        String yesOrNoQuestion = scanner.nextLine();
        handleChoice(yesOrNoQuestion, scanner, products, productMethods);

        System.out.println("\nFrom choices Enter the items u want to add to yr cart");
        cart.displayCartMethods(scanner,products,productMethods);





}
public static void handleChoice(String yesOrNoQuestion, Scanner scanner, List<Product>products, ProductImpl productMethods) {
    if (yesOrNoQuestion.equalsIgnoreCase("yes") ) {
        System.out.println("Enter to Search by category:");
        String userCategory = scanner.nextLine();
        List<Product> filteredProducts = productMethods.filterByCategory(products, userCategory);
        productMethods.printFilterProducts(filteredProducts, userCategory);
        System.out.printf("%s%s%s\n", ANSIColors.BOLD+ ANSIColors.YELLOW,"*****************************", ANSIColors.RESET);
        productMethods.viewProducts(products);
    }else {
        System.out.println("Keep exploring then\n");
        productMethods.viewProducts(products);
    }
}
}