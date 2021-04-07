import java.util.ArrayList;
import java.util.List;

public class Rentals {
    List<Rental> rentals = new ArrayList<Rental>();

    public Rentals() {
    }

    protected int getSize() {
        return rentals.size();
    }

    protected void showRentals() {
        for ( Rental rental: rentals ) {
            System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ") ;
            System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode()) ;
        }
    }

    protected void returnVideo(String videoTitle) {
        for ( Rental rental: rentals ) {
            if ( rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented() ) {
                rental.returnVideo();
                rental.getVideo().setRented(false);
                break ;
            }
        }
    }
}