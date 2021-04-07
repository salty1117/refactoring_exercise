public class PriceCodeRegular implements PriceCode {
    @Override
    public int getPriceCode() {
        return Video.REGULAR;
    }

    @Override
    public double getCharge(double charge, int daysRented) {
        double returnCharge = charge;

        returnCharge += 2;
        if (daysRented > 2)
            returnCharge += (daysRented - 2) * 1.5;

        return returnCharge;
    }
}
