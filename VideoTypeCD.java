public class VideoTypeCD extends VideoType{
    @Override
    int getLimit() {
        return 3;
    }

    @Override
    int getPenalty() {
        return 2;
    }
}
