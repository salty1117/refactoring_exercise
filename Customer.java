import java.util.Date;
import java.util.List;

public class Customer {
	private Rentals rentals = new Rentals();
	private String name;

	public Customer(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rentals getRentals() {
		return rentals;
	}

	public void setRentals(Rentals rentals) {
		this.rentals = rentals;
	}

	public void clearRentals() {
		this.rentals = new Rentals();
	}

	public void addRental(Rental rental) {
		rentals.rentals.add(rental);

	}

	protected void showRentals() {
		System.out.println("Name: " + getName() +
				"\tRentals: " + getRentals().getSize()) ;
		rentals.showRentals();
	}

	protected void returnVideo(String videoTitle) {
		rentals.returnVideo(videoTitle);
	}

	protected void listRentals() {
		rentals.listRentals();
	}

	protected int getRentalSize() {
		return rentals.getSize();
	}

	public String getReport() {
		Report report = new Report();
		report.addReport("Customer Report for " + getName() + "\n");

		rentals.getReport(report);

		return report.getReport() ;
	}

	protected void rentVideo(Video foundVideo) {
		rentals.rentVideo(foundVideo);
	}
}
