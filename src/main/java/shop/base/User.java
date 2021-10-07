package shop.base;

import java.util.ArrayList;
import java.util.UUID;

public interface User {

    UUID getId();

    String getName();

    ArrayList<Order> getOrderList();

}
