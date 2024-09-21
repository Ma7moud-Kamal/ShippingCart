package org.example.services.impl;

import org.example.ansi.ANSIColors;
import org.example.model.Product;
import org.example.services.interfaces.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements ProductService {
    @Override
    public  void viewProducts(List<Product> list){
        for (Product p : list) {
            System.out.println(p);
        }
    }
    @Override
    public List<Product>filterByCategory(List<Product> products, String category) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getDescription().equalsIgnoreCase(category)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
    public void printFilterProducts(List<Product>list, String userCategory) {
        // Step 4: Print the filtered products
        if (list.isEmpty()) {
            System.out.printf("No products found in the %s%s%s\n", ANSIColors.BOLD+ANSIColors.RED, userCategory , ANSIColors.RESET+ "' category.");
        } else {
            System.out.printf("Products in the %s%s%s\n", ANSIColors.BOLD+ANSIColors.RED, userCategory , ANSIColors.RESET+ "category:");
            for (Product product : list) {
                System.out.println(product);
            }
        }
    }

}
