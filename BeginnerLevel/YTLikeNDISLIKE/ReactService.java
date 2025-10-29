package YTLikeNDISLIKE;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ReactService {
    private final ConcurrentMap<String, VideoCounts> videoCounts = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, Reaction> userVideo = new ConcurrentHashMap<>();

    private String key(String userId, String videoId) {
        return userId + "##" + videoId;
    }

    public Counts getCounts(String videoId) {
        VideoCounts vc = videoCounts.getOrDefault(videoId, new VideoCounts());
        return new Counts(vc.likes.get(), vc.dislikes.get());
    }

    public void react(String userId, String videoId, Reaction newReaction) {
        String uvKey  = key(userId, videoId);

        VideoCounts counts = videoCounts.computeIfAbsent(videoId, id -> new VideoCounts());
        
        Reaction oldReaction = userVideo.getOrDefault(uvKey, Reaction.NONE);

        if(oldReaction == newReaction) {
            return;
        }

        if(oldReaction == Reaction.LIKE) {
            counts.likes.decrementAndGet();
        } else if(oldReaction == Reaction.DISLIKE) {
            counts.dislikes.getAndDecrement();
        }

        if (newReaction == Reaction.LIKE) {
            counts.likes.incrementAndGet();
            userVideo.put(uvKey, newReaction);
        } else if (newReaction == Reaction.DISLIKE) {
            counts.dislikes.incrementAndGet();
            userVideo.put(uvKey, newReaction);
        } else {
            userVideo.remove(uvKey);
        }
    }

    public static class Counts {
        public final int likes;
        public final int dislikes;

        public Counts(int likes, int dislikes) {
            this.likes = likes;
            this.dislikes = dislikes;
        }

        @Override
        public String toString() {
            return "Likes = " + likes + ", Dislikes = " + dislikes;
        }
    }
}
