package service;

import base.Cart;
import base.Item;

public class CartService {

    public static void add(Cart cart, Item item) {
        cart.getItemMap()
                .put(item, cart.getItemMap().getOrDefault(item, 0) + 1);
    }

    public static void delete(Cart cart, Item item) {
        cart.getItemMap().remove(item);
    }

    public static void clear(Cart cart) {
        cart.getItemMap().clear();
    }
}
