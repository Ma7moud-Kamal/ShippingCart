package org.example.shopping.items;

import org.example.ansi.ANSIColors;
import org.example.model.Product;
import org.example.services.impl.InputHandler;
import org.example.services.impl.OrderImpl;
import org.example.services.impl.ProductImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class CartImpl implements CartServices {
    List<Product>productsInCart = new ArrayList<>();
    OrderImpl order  ;
    Scanner scanner2  = new Scanner(System.in);
    @Override
    public void displayCartMethods(Scanner scanner,List<Product>products, ProductImpl productMethods) {
        int choice ;
        do {
            printMenu();
            choice = InputHandler.getUserChoice(scanner);
            displayMethodFromUser(choice, products, productMethods, scanner);
        }while (choice > 0 && choice < 6);
    }
    private void printMenu() {
        System.out.println("\n1. Add By ID");
        System.out.println("2. Update Quantity");
        System.out.println("3. Remove By ID");
        System.out.println("4. View Cart Items");
        System.out.println("5. Make Order");
        System.out.println("Enter your choice:");    }

    @Override
    public void displayMethodFromUser(int numberFromUser, List<Product>products, ProductImpl productMethods,Scanner scanner) {
        switch (numberFromUser) {
            case 1:
                handleAddById(products, scanner);
                break;
            case 2:
                handleUpdateQuantity(scanner);
                break;
            case 3:
                handleRemoveById(scanner);
                break;
            case 4:
                viewCart();
                break;
            case 5:
             handleMakeOrder();
            default:
                if (numberFromUser != -1) {
                    System.out.println("Invalid choice. Please select a number between 1 and 5.");
                }
        }
    }
    private void handleAddById(List<Product> productList, Scanner scanner) {
        System.out.println("Enter the ID you want to add:");
        if (scanner.hasNextInt()) {
            int idToAdd = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            addProductByID(productList, idToAdd);
        } else {
            System.out.println("Invalid ID. Please enter a valid integer.");
            scanner.nextLine(); // Consume invalid input
        }
    }
    private void handleUpdateQuantity(Scanner scanner) {
        System.out.println("Enter the ID you want to update:");
        if (scanner.hasNextInt()) {
            int idToUpdate = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            updateQuantity(idToUpdate);
        } else {
            System.out.println("Invalid ID. Please enter a valid integer.");
            scanner.nextLine(); // Consume invalid input
        }
    }

    private void handleRemoveById(Scanner scanner) {
        System.out.println("Enter the ID you want to remove:");
        if (scanner.hasNextInt()) {
            int idToRemove = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            removeProduct(idToRemove);
        } else {
            System.out.println("Invalid ID. Please enter a valid integer.");
            scanner.nextLine(); // Consume invalid input
        }
    }
    private void handleMakeOrder() {
        System.out.println("Do you have a discount code? If yes, choose from (CODE10, CODE30, CODE50). If not, enter (EMPTY): ");
        String userChoice = scanner2.nextLine().trim();
        if (DiscountEnumCheck.checkEnumFields(userChoice)) {
            order = new OrderImpl();
            order.makeOrder(getProductsInCart(), userChoice);
            clearCart();
        } else {
            System.out.println("You entered a wrong code for discount, so your order is cancelled. Please try again.");
        }
    }

@Override
public void viewCart() {
    if (productsInCart.isEmpty()) {
        System.out.println("Your cart is empty.");
    } else {
        System.out.println("\nItems in your cart:");
        for (Product product : productsInCart) {
            System.out.printf("Product: %s%s%s, Quantity in Cart: %d\n",
                    ANSIColors.BOLD + ANSIColors.RED,
                    product.getName(),
                    ANSIColors.RESET,
                    product.getQuantityInCart());
        }
    }
}
    @Override
    public void addProductByID(List<Product> productList, int id) {
        Product productToAdd = findProductById(productList, id);
        if (productToAdd == null) {
            System.out.println("Product with ID " + id + " not found.");
            return;
        }

        if (productToAdd.getQuantity() <= 0) {
            System.out.println("Product " + productToAdd.getName() + " is out of stock.");
            return;
        }

        Product productInCart = findProductInCartById(id);
        if (productInCart != null) {
            productInCart.setQuantityInCart(productInCart.getQuantityInCart() + 1);
            productToAdd.setQuantity(productToAdd.getQuantity() - 1);
            printInColor(productInCart.getName(), productInCart.getQuantity(), productInCart.getQuantity());
        } else {
            productToAdd.setQuantityInCart(1);
            productsInCart.add(productToAdd);
            productToAdd.setQuantity(productToAdd.getQuantity() - 1);
            printInColor(productToAdd.getName(), productToAdd.getQuantity(), productToAdd.getQuantity());
        }
        if (productToAdd.getQuantity() == 0) {
            System.out.println("Product " + productToAdd.getName() + " is now out of stock.");
        }
    }
@Override
public void updateQuantity(int id) {
    Product productInCart = findProductInCartById(id);
    if (productInCart == null) {
        System.out.println("Product with ID " + id + " is not in the cart.");
        return;
    }

    if (productInCart.getQuantity() <= 0) {
        System.out.println("Cannot update quantity. Product " + productInCart.getName() + " is out of stock.");
        return;
    }

    productInCart.setQuantityInCart(productInCart.getQuantityInCart() + 1);
    productInCart.setQuantity(productInCart.getQuantity() - 1);
    printInColor(productInCart.getName(), productInCart.getQuantity(), productInCart.getQuantity());
    if (productInCart.getQuantity() == 0) {
        System.out.println("Product " + productInCart.getName() + " is now out of stock.");
    }
}

@Override
public void removeProduct(int id) {
    Product productInCart = findProductInCartById(id);
    if (productInCart == null) {
        System.out.println("Product with ID " + id + " is not in the cart.");
        return;
    }

    if (productInCart.getQuantityInCart() > 1) {
        productInCart.setQuantityInCart(productInCart.getQuantityInCart() - 1);
        productInCart.setQuantity(productInCart.getQuantity() + 1); // Return to inventory
       printInColor(productInCart.getName(), productInCart.getQuantity(), productInCart.getQuantity());
    } else {
        productsInCart.remove(id);
        productInCart.setQuantity(productInCart.getQuantity() + 1); // Return to inventory
        System.out.printf("The Product named %s%s%s has been removed successfully.\n",
                ANSIColors.BOLD + ANSIColors.RED,
                productInCart.getName(),
                ANSIColors.RESET);
    }
}
    @Override
    public void createProducts(List<Product> products) {
        Product p1 = new Product(1, "Jacket", "Clothes", 500, 10);
        Product p2 = new Product(2, "T-Shirt", "Clothes", 175, 6);
        Product p3 = new Product(3, "Trousers", "Clothes", 300, 5);
        Product p4 = new Product(4, "Shoes", "Shoes & Bags", 400, 8);
        Product p5 = new Product(5, "Bags", "Shoes & Bags", 250, 7);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
    }
    private Product findProductInCartById(int id) {
        for (Product product : productsInCart) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
private Product findProductById(List<Product> productList, int id) {
    for (Product product : productList) {
        if (product.getId() == id) {
            return product;
        }
    }
    return null;
}
    private List<Product> getProductsInCart() {
        return new ArrayList<>(productsInCart);
    }
    private void clearCart() {
        productsInCart.clear();
        System.out.println("Your cart has been cleared after placing the order.");
    }
    @Override
    public void printInColor(String name, int quantityBefore, int quantityAfter){
        System.out.printf("The Quantity of the product %s%s%s has updated to %s%d%s from %s%d%s items\n",
                ANSIColors.BOLD + ANSIColors.RED,
                name,
                ANSIColors.RESET,
                ANSIColors.BOLD + ANSIColors.RED,
                quantityBefore,
                ANSIColors.RESET,
                ANSIColors.BOLD + ANSIColors.RED,
                quantityAfter - 1,
                ANSIColors.RESET
        );
    }



}
