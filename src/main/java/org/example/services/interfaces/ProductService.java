package org.example.services.interfaces;
import org.example.model.Product;

import java.util.List;

public interface ProductService {
//    void createProducts(List<Product>products);

    void viewProducts(List<Product> products);


    List<Product> filterByCategory(List<Product> products, String category);
    void printFilterProducts(List<Product>list, String userCategory);

}
