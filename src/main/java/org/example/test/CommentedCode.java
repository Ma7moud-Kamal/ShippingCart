package org.example.test;

import org.example.services.impl.OrderImpl;
import org.example.shopping.items.CartImpl;

public class CommentedCode {
//    CartImpl
    //    @Override
//    public void viewCart(List<Product>productsInCartToView){
//        for (Product product : productsInCartToView) {
////            product.setQuantityInCart(product.getQuantityInCart());
////            System.out.println(product);
//            System.out.println(product.getName() + " (Quantity in Cart: " + product.getQuantityInCart() + ")");
//
//        }
//    }
    //    public void addProductByID(List<Product> productList, int id ){
//        for (Product productInCart : productList) {
//            if (productInCart.getId() == id) {
////                productInCart.setQuantityInCart(itemQuantity+1);
//                productInCart.setQuantity(productInCart.getQuantity()-1);
//                printInColor(productInCart.getName(), productInCart.getQuantity(), productInCart.getQuantity());
//                productsInCart.add(productInCart);
//                System.out.println(productInCart+ "  added successfully");
//            }
//        }
//    }
//    public void addProductByID(List<Product> productList, int id) {
//        for (Product product : productList) {
//            if (product.getId() == id) {
//                Product cartProduct = findProductInCartById(id);
//                if (cartProduct != null) {
//                    cartProduct.setQuantityInCart(cartProduct.getQuantityInCart() + 1);
//                } else {
//                    product.setQuantityInCart(1);
//                    productsInCart.add(product);
//                }
//                product.setQuantity(product.getQuantity() - 1);
//                System.out.println(product.getName() + " added successfully. Current quantity in cart: " + product.getQuantityInCart());
//            }
//        }
//    }

//    @Override
//    public void updateQuantity(Product product){
//        product.setQuantity(product.getQuantity()-1);
//        productsInCart.add(product);
//        printInColor(product.getName(), product.getQuantity(), product.getQuantity());
//    }
//    @Override
//    public void removeProduct(Product product){
//        String name = product.getName();
//        productsInCart.remove(product);
//        System.out.printf("The Product named  %s%s%s has removed successfully \n", ANSIColors.BOLD+ANSIColors.RED,product.getName(),  ANSIColors.RESET);
//        viewCart(productsInCart);
//    }
//@Override
//public void updateQuantity(Product product) {
//    product.setQuantity(product.getQuantity() - 1);
//    product.setQuantityInCart(product.getQuantityInCart() + 1);
//    System.out.println(product.getName() + " quantity updated. Current quantity in cart: " + product.getQuantityInCart());
//}
    //    @Override
//    public void removeProduct(Product product) {
//        if (product.getQuantityInCart() > 1) {
//            product.setQuantityInCart(product.getQuantityInCart() - 1);
//            System.out.println(product.getName() + " quantity decreased. Current quantity in cart: " + product.getQuantityInCart());
//        } else {
//            productsInCart.remove(product);
//            System.out.println(product.getName() + " removed from the cart.");
//        }
//        product.setQuantity(product.getQuantity() + 1); // Return one item to the inventory
//    }


//    OrderImpl
    //    public void makeOrder(List<Product> productsOrder, String discountForUser) {
//        int totalPrice = 0;
//        System.out.println("Thank you for your order");
//        System.out.println("The items you ordered are: ");
//        for (Product product : productsOrder) {
//            System.out.println(product);
//            totalPrice= totalPrice + product.getPrice();
//        }
//        System.out.printf("\nAnd the total price of the items is: %s%s%s\n",ANSIColors.BOLD+ANSIColors.RED,totalPrice, ANSIColors.RESET);
//        applyDiscount(totalPrice, Discount.valueOf(discountForUser));
//        displayUserData();
//        processPayment();
//    }
}
