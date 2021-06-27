package com.exposit.models;

import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Order {
    @NonNull
    private User user;
    @NonNull
    private List<Product> shoppingList;
    private int costOfProducts;

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", shoppingList=" + shoppingList +
                ", costOfProducts=" + costOfProducts +
                '}';
    }
}

