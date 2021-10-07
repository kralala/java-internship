import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import shop.base.Item;
import shop.implementations.cart.StoreCart;
import shop.implementations.item.Berry;
import shop.implementations.item.BerryParameters;
import shop.implementations.item.Herb;
import shop.implementations.item.HerbParameters;
import shop.implementations.order.StoreOrder;
import shop.implementations.user.StoreUser;
import shop.service.CartService;
import shop.service.OrderService;

public class Tests {

    @InjectMocks
    private StoreUser userM;
    @InjectMocks
    private StoreCart cartM;
    @InjectMocks
    private StoreOrder orderM;

    @Test
    public void testAddItem() {
        OrderService.addOrder(userM, orderM);
        CartService.add(cartM, new Herb(HerbParameters.CINNAMON),1);
        Assert.assertEquals(1, userM.getOrderList().size());
        CartService.add(cartM, new Berry(BerryParameters.CRANBERRY),2);
        Assert.assertEquals(2, userM.getOrderList().size());
        CartService.add(cartM, new Berry(BerryParameters.SEA_BUCKTHORN),-4);
        Assert.assertEquals(2, userM.getOrderList().size());
    }

    @Test
    public void testRemoveItemByCount() {
        OrderService.addOrder(userM, orderM);
        Item linden = new Herb(HerbParameters.LINDEN);
        CartService.add(cartM, linden,2);
        Assert.assertEquals(1, userM.getOrderList().size());
        CartService.reduce(cartM, linden, 2);
        Assert.assertEquals(0, userM.getOrderList().size());
    }

    @Test
    public void testRemoveItemByMethod() {
        OrderService.addOrder(userM, orderM);
        Item cowberry = new Berry(BerryParameters.COWBERRY);
        CartService.add(cartM, cowberry, 5);
        Assert.assertEquals(1, userM.getOrderList().size());
        CartService.remove(cartM, cowberry);
        Assert.assertEquals(0, userM.getOrderList().size());
    }

    @Test
    public void testReduceItem() {
        OrderService.addOrder(userM, orderM);
        Item mint = new Herb(HerbParameters.PEPPERMINT_AUS);
        CartService.reduce(cartM, mint, -7);
        Assert.assertEquals(0, userM.getOrderList().size());
        CartService.add(cartM, mint, 3);
        Assert.assertEquals(1, userM.getOrderList().size());
        CartService.reduce(cartM, mint, 3);
        Assert.assertEquals(0, userM.getOrderList().size());
    }

    @Test
    public void testTotalPrice() {
        OrderService.addOrder(userM, orderM);
        CartService.add(cartM, new Berry(BerryParameters.SEA_BUCKTHORN),3);
        Assert.assertEquals(570, orderM.getCheckout());
    }
}
