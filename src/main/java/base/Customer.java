package base;

import java.util.ArrayList;
import java.util.UUID;

public interface Customer {

    public UUID getId();

    public Cart getCart();

    public ArrayList<Order> getOrderList();

    public void setCart(Cart cart);
}
