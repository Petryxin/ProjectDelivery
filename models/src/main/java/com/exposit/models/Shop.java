package com.exposit.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Shop {
    private String shopName;
    private String shopAddress;
    private List<Product> listProducts;

    @Override
    public String toString() {
        return "Shop{" +
                "shopName='" + shopName + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", listProducts=" + listProducts +
                '}';
    }
}
