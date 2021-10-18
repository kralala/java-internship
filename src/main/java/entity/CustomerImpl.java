package entity;

import base.Cart;
import base.Customer;
import base.Item;
import base.Order;

import java.util.ArrayList;
import java.util.UUID;

public class CustomerImpl implements Customer {
    private UUID id;
    private String name;
    private Cart cart;
    private ArrayList<Order> orderList;

    public CustomerImpl(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cart = new CartImpl();
        this.orderList = new ArrayList<>();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    @Override
    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
