import java.util.ArrayList;
import java.util.List;

public class Videos {
    List<Video> videos = new ArrayList<Video>();

    public Videos() {
    }

    protected void listVideos() {
        for ( Video video: videos) {
            System.out.println("Price code: " + video.getPriceCode() +"\tTitle: " + video.getTitle()) ;
        }
    }
}