public class VideoTypeDVD extends VideoType{
    @Override
    int getLimit() {
        return 2;
    }

    @Override
    int getPenalty() {
        return 3;
    }
}
