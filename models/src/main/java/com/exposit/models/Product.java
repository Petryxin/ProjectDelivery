package com.exposit.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private String productName;
    private String manufacturer;
    private int productCost;
    private int numberOfProducts;
    private List<Category> categoryList;


    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", productCost=" + productCost +
                ", numberOfProducts=" + numberOfProducts +
                ", categoryList=" + categoryList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productCost == product.productCost &&
                numberOfProducts == product.numberOfProducts &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(manufacturer, product.manufacturer) &&
                Objects.equals(categoryList, product.categoryList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, manufacturer, productCost, numberOfProducts, categoryList);
    }
}

