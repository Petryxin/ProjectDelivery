package com.exposit.starter;

import com.exposit.models.*;
import com.exposit.service.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationStarter {
    public static void main(String[] args){
        List<User> userList = new ArrayList<>();
        List<Shop> shopList = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();
        DeliveryService deliveryService = new DeliveryService();
        Delivery delivery = deliveryService.createDelivery("SpeedDelivery", shopList,userList,orderList);

        UserService userService = new UserService();
        User kolia = userService.userRegistrationInDelivery("kolia99","kolia99@mail.com",  "1111",
                "Kolia","Kypaly 80", 80299966711L);
        User ilia = userService.userRegistrationInDelivery("ilia89","ilia89@mail.com",  "2222",
                "Ilia", "Lermontova 34", 80298833177L);

        ShopService shopService = new ShopService();
        Shop almi = shopService.shopRegistrationInDelivery("Almi", "Kosmonavtov 32",
                new ArrayList<>());
        Shop evro = shopService.shopRegistrationInDelivery("Evro", "Antonova 4",
                new ArrayList<>());

        deliveryService.addUserToList(delivery,kolia);
        deliveryService.addUserToList(delivery,ilia);
        deliveryService.addShopToList(delivery,almi);
        deliveryService.addShopToList(delivery,evro);

        ProductService productService = new ProductService();
        List<Category> categoryListForKasha = new ArrayList<>();
        categoryListForKasha.add(Category.PORRIDGE);
        List<Category> categoryListForLapsha = new ArrayList<>();
        categoryListForLapsha.add(Category.FAST_FOOD);
        categoryListForLapsha.add(Category.PORRIDGE);
        Product kasha = productService.createProduct("Kasha", "Lidkon",30,
                3, categoryListForKasha);
        Product lapsha = productService.createProduct("Lapsha", "PSGroup", 15,
                2, categoryListForLapsha);
        Product kasha1 = productService.createProduct("Kasha", "Kraps",20,
                1, categoryListForKasha);

        shopService.addProductToShop(almi,kasha);
        shopService.addProductToShop(evro, lapsha);
        shopService.addProductToShop(evro, kasha1);
        shopService.addProductToShop(evro,kasha);

        List<Product> listOfProductsInShopEvro = shopService.getListOfProductsInShop(evro);
        System.out.println("Products in shop Evro - " + listOfProductsInShopEvro);
        System.out.println();

        List<Shop> shopsWithCertainProductCategory = deliveryService
                .findShopsWithCertainProductCategory(shopList, Category.PORRIDGE);
        System.out.println("Shops with certain product category PORRIDGE - " + shopsWithCertainProductCategory);
        System.out.println();

        List<Product> productListByCategory = shopService.getProductByCategory(evro, Category.PORRIDGE);
        System.out.println("Product list by category PORRIDGE in the shop Evro - " + productListByCategory);
        System.out.println();

        List<Product> sortProductsInAscendingPrice = shopService.sortProductsInAscendingPrice(productListByCategory);
        System.out.println("AscendingPrice" + sortProductsInAscendingPrice);
        List<Product> sortProductsInDescendingPrice = shopService.sortProductsInDescendingPrice(productListByCategory);
        System.out.println("DescendingPrice" + sortProductsInDescendingPrice);
        System.out.println();

        List<Product> products = shopService.findProductBytName(evro, "Kasha");
        System.out.println("Products by Name" + products);
        List<Product> productByNameAndManufacturer = shopService.findProductByNameAndManufacturer(evro,
                "Kasha", "Lidkon");
        System.out.println("Products by Name and Manufacturer" + productByNameAndManufacturer);
        System.out.println();

        OrderService orderService = new OrderService();
        Order order = orderService.createOrder(ilia, new ArrayList<>());
        orderService.addProductToShoppingList(order,evro,kasha1);
        orderService.addProductToShoppingList(order,evro,lapsha);
        System.out.println(order);
        deliveryService.addOrderToList(delivery,order);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File("data.json");
        try {
            FileWriter writer = new FileWriter(file,true);
            gson.toJson(delivery,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
