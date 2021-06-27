package com.exposit.service;

import com.exposit.models.Order;
import com.exposit.models.Product;
import com.exposit.models.Shop;
import com.exposit.models.User;

import java.util.List;

public class OrderService {
    public Order createOrder(User user, List<Product> shoppingList){
        Order order = new Order(user, shoppingList);
        return  order;
    }

    public int calculateCostOfProducts(Order order){
        List<Product> productList = order.getShoppingList();
        int sum = productList.stream().mapToInt(Product::getProductCost).sum();
        return sum;
    }

    public void addProductToShoppingList(Order order, Shop shop, Product product){
        ShopService shopService = new ShopService();
        Product selectedProductFromList = shopService.selectedProductFromList(shop, product);
        if (selectedProductFromList == null) {
            throw new IllegalArgumentException("Shop - " + shop.getShopName()+ " doesn't have product - "
                    + product.getProductName());
        }else {
            order.getShoppingList().add(selectedProductFromList);
            order.setCostOfProducts(calculateCostOfProducts(order));
            shopService.decreaseInNumberOfProducts(shop,product);
            System.out.println(product.getProductName() + " has been successfully added to your shopping list");
        }
    }
}
