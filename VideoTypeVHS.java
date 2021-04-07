public class VideoTypeVHS extends VideoType{

    @Override
    int getLimit() {
        return 5;
    }

    @Override
    int getPenalty() {
        return 1;
    }
}
