package com.exposit.service;
import com.exposit.models.Category;
import com.exposit.models.Product;


import java.util.List;

public class ProductService {
    public Product createProduct(String productName, String manufacturer, int productCost, int numberOfProducts,
                                 List<Category> categoryList){
        Product product = new Product(productName,manufacturer, productCost,numberOfProducts,categoryList);
        return product;
    }
}
