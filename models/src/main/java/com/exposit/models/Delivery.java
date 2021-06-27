package com.exposit.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Delivery {
    private String serviceName;
    private List<Shop> shopList;
    private List<User> userList;
    private List<Order> orderList;

    @Override
    public String toString() {
        return "Delivery{" +
                "serviceName='" + serviceName + '\'' +
                ", shopList=" + shopList +
                ", userList=" + userList +
                ", orderList=" + orderList +
                '}';
    }
}
