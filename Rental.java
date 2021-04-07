import java.util.Date;

public class Rental {
	private Video video ;

	private int status ;
	private static final int RENTED = 0;
	private static final int RETURNED = 1;

	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		status = RENTED ;
		rentDate = new Date() ;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public int getStatus() {
		return status;
	}

	public void returnVideo() {
		if ( status == RENTED ) {
			this.status = RETURNED;
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getDaysRentedLimit() {
		int limit = 0 ;
		int daysRented = getDaysRented();
		if ( daysRented <= 2) return limit ;

		limit = video.getLimit(limit);
		return limit ;
	}

	public void getReport(Report report) {
		double eachCharge = 0;
		int eachPoint = 0 ;
		int daysRented = getDaysRented();

		eachCharge = getEachCharge(eachCharge, daysRented);

		eachPoint = getEachPoint(eachPoint, daysRented);

		report.addReport(
				"\t" + getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + eachCharge
				+ "\tPoint: " + eachPoint + "\n"
		);

		report.addCharge(eachCharge);
		report.addPoint(eachPoint) ;
	}

	private int getEachPoint(int eachPoint, int daysRented) {
		int returnPoint = eachPoint;
		returnPoint++;

		if ((getVideo().getPriceCode() == Video.NEW_RELEASE) )
			returnPoint++;

		if ( daysRented > getDaysRentedLimit() )
			returnPoint -= Math.min(returnPoint, getVideo().getLateReturnPointPenalty()) ;
		return returnPoint;
	}

	private double getEachCharge(double eachCharge, int daysRented) {
		double returnCharge = eachCharge;

		switch (getVideo().getPriceCode()) {
			case Video.REGULAR:
				returnCharge += 2;
				if (daysRented > 2)
					returnCharge += (daysRented - 2) * 1.5;
				break;
			case Video.NEW_RELEASE:
				returnCharge = daysRented * 3;
				break;
		}
		return returnCharge;
	}

	private int getDaysRented() {
		int daysRented = 0;

		if (getStatus() == RETURNED) { // returned Video
			long diff = getReturnDate().getTime() - getRentDate().getTime();
			daysRented = calculateDay(diff);
		} else { // not yet returned
			long diff = new Date().getTime() - getRentDate().getTime();
			daysRented = calculateDay(diff);
		}

		return daysRented;
	}

	private int calculateDay(long diff) {
		return (int) (diff / (1000 * 60 * 60 * 24)) + 1;
	}

	public void setRented(Video foundVideo) {
		foundVideo.setRented(true);
	}
}
