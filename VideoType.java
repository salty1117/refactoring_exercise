public abstract class VideoType {
    int videoType;

    public VideoType() {
    }

    abstract int getLimit();
    abstract int getPenalty();
}