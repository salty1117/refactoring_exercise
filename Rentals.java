import java.util.ArrayList;
import java.util.Date;
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

    protected void listRentals() {
        for ( Rental rental: rentals ) {
            System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ") ;
            System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode()) ;
        }
    }

    protected String getReport(Report report) {
        for (Rental each : rentals) {
            each.getReport(report);
        }

        report.addReport("Total charge: " + report.getTotalCharge() + "\tTotal Point:" + report.getTotalPoint() + "\n");

        giveReward(report.getTotalPoint());

        return report.getReport();
    }

    private void giveReward(int totalPoint) {
        if ( totalPoint >= 10 ) {
            System.out.println("Congrat! You earned one free coupon");
        }
        if ( totalPoint >= 30 ) {
            System.out.println("Congrat! You earned two free coupon");
        }
    }
}