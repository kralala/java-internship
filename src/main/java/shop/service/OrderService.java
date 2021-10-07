package shop.service;

import shop.base.Order;
import shop.base.User;
import shop.implementations.cart.StoreCart;
import shop.implementations.order.StoreOrder;

import static shop.service.CartService.clear;

public class OrderService {

    public static void addOrder(User user, Order order) {
        user.getOrderList().add(order);
    }

    public static void printOrder(Order order) {
        for (var entry : order.getCart().getItemList().entrySet()) {
            System.out.println(entry.getKey().toString());
        }
    }

    public static void refreshOrderList(User user, Order order) {
        user.getOrderList().clear();
    }

    public static void refreshOrder(Order order) {
        clear(order.getCart());
    }
}
