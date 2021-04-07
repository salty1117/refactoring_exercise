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

    protected void clearRentals(String customerName) {
        Customer foundCustomer = getCustomer(customerName);

        if ( foundCustomer == null ) {
            System.out.println("No customer found") ;
        } else {
            foundCustomer.showRentals();
            foundCustomer.clearRentals();
        }
    }

    protected boolean hasCustomer(String customerName) {
        return getCustomer(customerName) != null;
    }

    protected void returnVideo(String customerName, String videoTitle) {
        Customer foundCustomer = getCustomer(customerName);

        foundCustomer.returnVideo(videoTitle);
    }

    protected void listCustomers() {
        for ( Customer customer: customers) {
            System.out.println("Name: " + customer.getName() +
                    "\tRentals: " + customer.getRentalSize()) ;
            customer.listRentals();
        }
    }

    protected void getReport(String customerName) {
        Customer foundCustomer = getCustomer(customerName);

        if ( foundCustomer == null ) {
            System.out.println("No customer found") ;
        } else {
            String result = foundCustomer.getReport() ;
            System.out.println(result);
        }
    }

    protected void rentVideo(String customerName, Video foundVideo) {
        Customer foundCustomer = getCustomer(customerName);

        foundCustomer.rentVideo(foundVideo);
    }
}