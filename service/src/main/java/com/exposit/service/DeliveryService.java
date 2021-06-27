package com.exposit.service;

import com.exposit.models.*;

import java.util.List;
import java.util.stream.Collectors;


public class DeliveryService {
    public Delivery createDelivery (String serviceName, List<Shop> shopList,List<User> userList, List<Order> orderList){
        Delivery delivery = new Delivery(serviceName,shopList,userList,orderList);
        return delivery;
    }

    public void addUserToList(Delivery delivery, User user){
        delivery.getUserList().add(user);
    }

    public void deleteUserFromList(Delivery delivery, User user){
        delivery.getUserList().remove(user);
    }

    public void addShopToList(Delivery delivery, Shop shop){
        delivery.getShopList().add(shop);
    }

    public void deleteShopFromList(Delivery delivery, Shop shop){
        delivery.getShopList().remove(shop);
    }

    public void addOrderToList(Delivery delivery, Order order){
        delivery.getOrderList().add(order);
    }

    public void deleteOrderFromList(Delivery delivery, Order order){
        delivery.getUserList().remove(order);
    }

    public List<Shop> findShopsWithCertainProductCategory(List<Shop> shop, Category category) {
        ShopService shopService = new ShopService();
        List<Shop> shopList = shop.stream().filter(c -> c.getListProducts().stream()
                .filter(product -> product.getCategoryList().stream().anyMatch(categ -> categ.equals(category)))
                .count() != 0).collect(Collectors.toList());
        return shopList;
    }
}
