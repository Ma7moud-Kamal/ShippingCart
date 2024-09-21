package org.example.services.impl;

import org.example.ansi.ANSIColors;
import org.example.model.Product;
import org.example.model.User;
import org.example.services.interfaces.OrderService;
import org.example.shopping.items.Discount;
import java.util.List;
import java.util.Scanner;

public class OrderImpl implements OrderService {
    User user = new User(1,"Kamal","km@gmail.com","123","123456789");
    Scanner scanner = new Scanner(System.in);
    @Override
    public void makeOrder(List<Product> productsInCart, String discountCode) {
        if (productsInCart.isEmpty()) {
            System.out.println("Your cart is empty. Add items before making an order.");
            return;
        }

        double total = 0;
        for (Product product : productsInCart) {
            total += product.getPrice() * product.getQuantityInCart();
        }
        System.out.printf("Your order has been placed successfully! Total amount: $%.2f\n", total);
        applyDiscount((int)total, Discount.valueOf(discountCode));
        displayUserData();
        processPayment();
    }
    @Override
    public void applyDiscount(int totalPriceForOrder,Discount discount){
        switch (discount) {
            case CODE10:
                totalPriceForOrder = (int) (totalPriceForOrder - (totalPriceForOrder * 0.1));
                System.out.printf("The total price after discount is: %s%s%s\n", ANSIColors.BOLD+ANSIColors.RED, totalPriceForOrder , ANSIColors.RESET);
                break;
            case CODE30:
                totalPriceForOrder = (int) (totalPriceForOrder - (totalPriceForOrder * 0.3));
                System.out.printf("The total price after discount is: %s%s%s\n", ANSIColors.BOLD+ANSIColors.RED, totalPriceForOrder , ANSIColors.RESET);
                break;
            case CODE50:
                totalPriceForOrder = (int) (totalPriceForOrder - (totalPriceForOrder * 0.5));
                System.out.printf("The total price after discount  is: %s%s%s\n", ANSIColors.BOLD+ANSIColors.RED, totalPriceForOrder , ANSIColors.RESET);
                break;
            case EMPTY:
                System.out.printf("There is no Discount so your total price is: %s%s%s\n", ANSIColors.BOLD+ANSIColors.RED, totalPriceForOrder , ANSIColors.RESET);
                break;
        }
    }
    @Override
    public void displayUserData(){
        System.out.println("The user data is: ");
        System.out.println(user);
    }
    @Override
    public void processPayment(){
        System.out.println("The payment is being processed");
        if (checkUserData()) {
            receiveSecureNumber();
        } else {
            System.out.println("Your Order is cancelled");
            System.exit(0);
        }
    }
    @Override
    public Boolean checkGmail(){
        System.out.println("Enter your gmail");
        String gm = scanner.nextLine();
        return gm.equals(user.getEmail());

    }
    @Override
    public Boolean checkPassword(){
        System.out.println("Enter your Password");
        String ps = scanner.nextLine();
        return ps.equals(user.getPassword());
    }
    @Override
    public Boolean checkCreditCard(){
        System.out.println("Enter your CreditCard number");
        String cd = scanner.nextLine();
        return cd.equals(user.getCreditCardNumber());
    }
    @Override
    public Boolean checkUserData(){
        return checkGmail() && checkPassword() && checkCreditCard();
    }

    @Override
    public void receiveSecureNumber() {
        int  secureNumber = (int) Math.floor(Math.random() * 10000000) ;
        System.out.printf("Here is your secure number for the order %s%s%s\n", ANSIColors.BOLD+ANSIColors.CYAN, secureNumber , ANSIColors.RESET);
        System.out.println("Are u received the secure number? Y or N");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            confirmOrder();
        }else {
            System.out.println("Your Order canceled, pls try again later");
            System.exit(0);
        }
    }

    @Override
    public void confirmOrder() {
        System.out.println("Your order is confirmed");
        System.out.printf("we are waiting u in the next time our fav customer %s%s%s\n", ANSIColors.BOLD+ANSIColors.RED, user.getName() , ANSIColors.RESET);
        System.exit(0);
    }


}
