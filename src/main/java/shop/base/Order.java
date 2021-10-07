package shop.base;

import java.util.UUID;

public interface Order {

    UUID getId();

    int getCheckout();

    Cart getCart();

}
