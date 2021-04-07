import java.util.Date;

public class Video {
	private String title ;

	private int priceCode ;
	public static final int REGULAR = 1 ;
	public static final int NEW_RELEASE =2 ;

	private VideoType videoType;
	public static final int VHS = 1 ;
	public static final int CD = 2 ;
	public static final int DVD = 3 ;

	private Date registeredDate ;
	private boolean rented ;

	public Video(String title, int videoType, int priceCode, Date registeredDate) {
		this.setTitle(title) ;
		switch (videoType) {
			case VHS: this.videoType = new VideoTypeVHS();
			case CD: this.videoType = new VideoTypeCD();
			case DVD: this.videoType = new VideoTypeDVD();
		}
		this.setVideoType(videoType) ;
		this.setPriceCode(priceCode) ;
		this.registeredDate = registeredDate ;
	}

	public int getLateReturnPointPenalty() {
		return videoType.getPenalty();
	}

	protected int getLimit(int limit) {
		return videoType.getLimit();
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public int getVideoType() {
		return videoType.videoType;
	}

	public void setVideoType(int videoType) {
		this.videoType.videoType = videoType;
	}
}
