package entity;

import base.Cart;
import base.Order;
import service.OrderService;

import java.util.UUID;

public class OrderImpl implements Order {
    private int id;
    private Cart cart;
    private long total;
    private int quantity;

    public OrderImpl(Cart cart, int id) {
        this.id = id;
        this.cart = cart;
        this.total = OrderService.getTotal(this.cart);
        this.quantity = OrderService.getQuantity(this.cart);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return String.valueOf(new StringBuilder()
                .append("Order ")
                .append(this.cart + " ")
                .append(this.total + " ")
                .append(this.quantity + ". "));
    }
}
