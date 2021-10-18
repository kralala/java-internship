import base.Cart;
import base.Customer;
import base.Item;
import entity.CartImpl;
import entity.CustomerImpl;
import entity.ItemImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.CustomerService;
import service.OrderService;

public class Tests {

    public Item item;
    public Customer customer;

    @BeforeEach
    public void startTest() {
        customer = new CustomerImpl("testCustomer");
        item = new ItemImpl("testItem1", 200L);
    }

    @Test
    public void testAdd() {
        CustomerService.addToCart(customer.getCart(), item);
        Assertions.assertEquals(customer.getCart().getItemMap().get(item),1);
    }

    @Test
    public void testDelete() {
        CustomerService.addToCart(customer.getCart(), item);
        CustomerService.deleteFromCart(customer.getCart(), item);
        Assertions.assertFalse(customer.getCart().getItemMap().containsKey(item));
    }

    @Test
    public void testClear() {
        CustomerService.addToCart(customer.getCart(), item);
        CustomerService.clearCart(customer.getCart());
        Assertions.assertEquals(customer.getCart().getItemMap().size(), 0);
    }

    @Test
    public void testTotal() {
        for (int i = 0; i < 10; i++) {
            CustomerService.addToCart(customer.getCart(), item);
        }
        Assertions.assertEquals(OrderService.getTotal(customer.getCart()),2000L);
    }

    @Test
    public void testQuantity() {
        for (int i = 0; i < 10; i++) {
            CustomerService.addToCart(customer.getCart(), item);
        }
        Assertions.assertEquals(OrderService.getQuantity(customer.getCart()),10);
    }

    @Test
    public void testCreate() {
        CustomerService.create(customer, 1);
        Assertions.assertEquals(customer.getOrderList().size(), 1);
    }

}
