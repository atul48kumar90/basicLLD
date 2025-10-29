package VideoViewTracker;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Video {
    private final String videoId;
    private final String title;
    private final AtomicInteger totalViews = new AtomicInteger(0);
    private final Set<String> uniqueViewers = new HashSet<>();

    public Video(String id, String title){
        this.videoId = id;
        this.title = title;
    }

    public String getId() {
        return videoId;
    }

    public String getTitle(){
        return title;
    }

    public int getTotalViews() {
        return totalViews.get();
    }

    public int getUniqueViews(){
        return uniqueViewers.size();
    }

    public synchronized void view(String userId){
        totalViews.incrementAndGet();
        uniqueViewers.add(userId);
    }
}
