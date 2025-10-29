package VideoViewTracker;

import java.util.HashMap;
import java.util.Map;

public class VideoService {
    private final Map<String, Video> videoMap = new HashMap<>();

    public void addVideo(String videoId, String title){
        videoMap.put(videoId, new Video(videoId, title));
    }

    public void viewVideo(String videoId, String userId){
        Video video = videoMap.get(videoId);
        if(video == null){
            System.out.println(" Video not found"); 
            return;
        }
        video.view(userId);
    }

    public void showVideoStats(String videoId) {
        Video video = videoMap.get(videoId);
        if (video == null) {
            System.out.println("❌ Video not found: " + videoId);
            return;
        }
        System.out.printf("🎬 %s → Total Views: %d, Unique Viewers: %d%n",
                video.getTitle(),
                video.getTotalViews(),
                video.getUniqueViews());
    }
}
