package shop.implementations.user;

import shop.base.Order;
import shop.base.User;

import java.util.ArrayList;
import java.util.UUID;

public class StoreUser implements User {

    private UUID id;
    private String name;
    private ArrayList<Order> orderList;

    public StoreUser(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.orderList = new ArrayList<Order>();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList getOrderList() {
        return orderList;
    }
}
