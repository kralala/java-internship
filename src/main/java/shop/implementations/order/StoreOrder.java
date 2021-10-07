package shop.implementations.order;

import shop.base.Cart;
import shop.base.Order;

import java.util.UUID;

public class StoreOrder implements Order {

    private UUID id;
    private Cart cart;
    private int checkout;

    public StoreOrder(Cart cart) {
        this.cart = cart;
        this.checkout = this.calculateCheckout();
        this.id = UUID.randomUUID();
    }

    private int calculateCheckout() {
        int sum = 0;
        for (var entry : cart.getItemList().entrySet()) {
            sum += (entry.getKey().getParameters().getPrice() * entry.getValue());
        }
        return sum;
    }

    @Override
    public int getCheckout() {
        return checkout;
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public UUID getId() {
        return id;
    }

}
