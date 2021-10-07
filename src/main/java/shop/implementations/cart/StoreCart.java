package shop.implementations.cart;

import shop.base.Cart;
import shop.base.Item;

import java.util.HashMap;
import java.util.Map;

public class StoreCart implements Cart {

    private Map<Item, Integer> itemList;

    public StoreCart() {
        this.itemList = new HashMap<Item, Integer>();
    }

    @Override
    public Map<Item, Integer> getItemList() {
        return itemList;
    }

    @Override
    public void setItemList(Map<Item, Integer> itemList) {
        this.itemList = itemList;
    }

}
