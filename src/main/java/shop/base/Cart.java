package shop.base;

import java.util.Map;

public interface Cart {

    Map<Item, Integer> getItemList();

    void setItemList(Map<Item, Integer> itemList);

}
