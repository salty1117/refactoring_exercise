import java.util.ArrayList;
import java.util.List;

public class Customers {
    List<Customer> customers = new ArrayList<Customer>();

    public Customers() {
    }

    protected Customer getCustomer(String customerName) {
        Customer foundCustomer = null;
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }
}