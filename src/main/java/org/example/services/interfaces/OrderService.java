package org.example.services.interfaces;

import org.example.model.Product;
import org.example.shopping.items.Discount;

import java.util.List;

public interface OrderService {
    void applyDiscount(int totalPriceForOrder,Discount discountFrUser);
    void makeOrder(List<Product>productsOrder, String discount);
    void displayUserData();
    void processPayment();
    Boolean checkGmail();
    Boolean checkPassword();
    Boolean checkCreditCard();
    Boolean checkUserData();
    void receiveSecureNumber();
    void confirmOrder();



}
