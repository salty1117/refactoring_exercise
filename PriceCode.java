public interface PriceCode {
    int getPriceCode();
    double getCharge(double charge, int daysRented);
}