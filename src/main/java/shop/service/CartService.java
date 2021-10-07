package shop.service;

import shop.base.Cart;
import shop.base.Item;

public class CartService {

    public static void add(Cart cart, Item item, int quantity) {
        if (quantity >= 0) {
            cart.getItemList()
                    .put(item, cart.getItemList().getOrDefault(item, 0) + quantity);
        }
    }

    public static void reduce(Cart cart, Item item, int quantity) {
        if (cart.getItemList().containsKey(item)) {
            if ((cart.getItemList().get(item) - quantity) < 0) {
                cart.getItemList().remove(item);
            }
            else {
                cart.getItemList()
                        .put(item, cart.getItemList().get(item) - quantity);
            }
        }
    }

    public static void remove(Cart cart, Item item) {
        if (cart.getItemList().containsKey(item)) {
            cart.getItemList().remove(item);
        }
    }

    public static void clear(Cart cart) {
        cart.getItemList().clear();
    }
}
