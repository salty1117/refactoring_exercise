public class PriceCodeNewRelease implements PriceCode{
    @Override
    public int getPriceCode() {
        return Video.NEW_RELEASE;
    }

    @Override
    public double getCharge(double charge, int daysRented) {
        return daysRented * 3;
    }
}
