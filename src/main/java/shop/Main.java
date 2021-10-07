package shop;

import shop.base.Cart;
import shop.base.Item;
import shop.base.Order;
import shop.base.User;
import shop.implementations.cart.StoreCart;
import shop.implementations.item.Berry;
import shop.implementations.item.BerryParameters;
import shop.implementations.item.Herb;
import shop.implementations.item.HerbParameters;
import shop.implementations.order.StoreOrder;
import shop.implementations.user.StoreUser;
import shop.service.CartService;
import shop.service.OrderService;

public class Main {
    public static void main(String[] args) {
        User user = new StoreUser("Albatross");
        Cart cart = new StoreCart();
        CartService.add(cart, new Berry(BerryParameters.CLOUDBERRY),6);
        CartService.add(cart, new Herb(HerbParameters.LINDEN), 8);
        OrderService.addOrder(user, new StoreOrder(cart));
        for (int i = 0; i < user.getOrderList().size(); i++){
            OrderService.printOrder(user.getOrderList().get(i));
        }
    }
}
