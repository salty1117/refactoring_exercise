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

    protected Video getVideo(String videoTitle) {
        Video foundVideo = null ;
        for ( Video video: videos) {
            if ( video.getTitle().equals(videoTitle) && video.isRented() == false ) {
                foundVideo = video ;
                break ;
            }
        }

        return foundVideo;
    }

}