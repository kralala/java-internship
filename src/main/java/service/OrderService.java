package service;

import base.Cart;

public class OrderService {
    public static long getTotal(Cart cart) {
        long total = 0;
        for (var entry : cart.getItemMap().entrySet()) {
            total += (entry.getKey().getPrice() * entry.getValue());
        }
        return total;
    }

    public static int getQuantity(Cart cart) {
        int quantity = 0;
        for (var entry : cart.getItemMap().entrySet()) {
            quantity += entry.getValue();
        }
        return quantity;
    }
}
