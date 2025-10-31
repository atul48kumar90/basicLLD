package IntermediateLevel.VideoViewTracker;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Video {
    private final String videoId;
    private final String title;
    private final String creator;
    private final AtomicInteger totlaView = new AtomicInteger(0);
    private Set<String> uniqueViews = new HashSet<>();

    public Video(String videoId, String title, String creator){
        this.videoId = videoId;
        this.title = title;
        this.creator = creator;
    }

    public int view(String userId){
        totlaView.getAndIncrement();
        uniqueViews.add(userId);
        return totlaView.get();
    }

    public int getUniqueView(){ return uniqueViews.size(); }
    public int getTotalView(){ return totlaView.get(); }
    public String getVideoId(){ return videoId; }
    public String getTitle(){ return title; }
    public String getCreator(){ return creator; }
}
