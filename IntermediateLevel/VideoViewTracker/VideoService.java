package IntermediateLevel.VideoViewTracker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class VideoService {
   private final VideoRepository videoRepository;
   private final Map<String, Set<String>> userWatchHistory = new ConcurrentHashMap<>();

   public VideoService(VideoRepository videoRepository){
    this.videoRepository = videoRepository;
   }

   public void addVideo(String id, String title, String creator){
    videoRepository.addvideo(id, title, creator);
   }

   public void watchVideo(String videoId, String userId){
     Video v = videoRepository.getVideo(videoId);
     if(v == null){
        System.out.println(" no video found");
        return;
     }

     ReentrantLock lock = videoRepository.getLock(videoId);
     lock.lock();
     try{
        v.view(userId);
        userWatchHistory.computeIfAbsent(userId, k -> new HashSet<>()).add(videoId);
     } finally{
        lock.unlock();
     }
   }
}
