package IntermediateLevel.VideoViewTracker;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class VideoRepository {
    Map<String, Video> videos = new HashMap<>();
    Map<String, ReentrantLock> locks = new HashMap<>();

    public void addvideo(String videoId, String title, String creator){
        Video v = new Video(videoId, title, creator);
        videos.put(videoId, v);
        locks.put(title, new ReentrantLock());
    }

    public Video getVideo(String videoId){
        return videos.get(videoId);
    }

    public void removeVideo(String videoId){ videos.remove(videoId);}

    public Collection<Video> getAllVideo(){ return videos.values();}

    public ReentrantLock getLock(String title){ return locks.get(title);}
}
