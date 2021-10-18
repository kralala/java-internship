package entity;

import base.Cart;
import base.Item;

import java.util.HashMap;

public class CartImpl implements Cart {
    private HashMap<Item, Integer> itemMap;

    public CartImpl() {
        this.itemMap = new HashMap<>();
    }

    @Override
    public HashMap<Item, Integer> getItemMap() {
        return itemMap;
    }

    @Override
    public String toString() {
        return String.valueOf(new StringBuilder()
                .append("Cart ")
                .append(this.itemMap + ". "));
    }
}
