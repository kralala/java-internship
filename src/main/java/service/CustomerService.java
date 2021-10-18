package service;

import base.Cart;
import base.Customer;
import base.Item;
import base.Order;
import entity.CartImpl;
import entity.OrderImpl;

public class CustomerService {

    public static void create(Customer customer, int orderId) {
        Order order = new OrderImpl(customer.getCart(), orderId);
        customer.getOrderList().add(order);
        Cart cart = new CartImpl();
        customer.setCart(cart);
    }

    public static void addToCart(Cart cart, Item item) {
        CartService.add(cart, item);
    }

    public static void deleteFromCart(Cart cart, Item item) {
        CartService.delete(cart, item);
    }

    public static void clearCart(Cart cart) {
        CartService.clear(cart);
    }

    public static void print(Customer customer) {
        for (var entry : customer.getOrderList()) {
            System.out.println(entry);
        }
    }
}
