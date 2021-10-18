import base.Customer;
import base.Item;
import entity.CustomerImpl;
import entity.ItemImpl;
import service.CustomerService;

public class Main {
    public static void main(String[] args) {
        Customer customer = new CustomerImpl("Albatross");

        Item mint = new ItemImpl("Mint", 240L);
        Item chamomile = new ItemImpl("Chamomile", 170L);

        CustomerService.create(customer, 1);

        CustomerService.addToCart(customer.getCart(), mint);
        CustomerService.addToCart(customer.getCart(), chamomile);
    }
}
