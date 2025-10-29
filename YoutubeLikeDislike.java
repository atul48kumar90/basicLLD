import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class YoutubeLikeDislike {
    private final ConcurrentMap<String, Reaction> userVideo = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, VideoCounts> videoCounts = new ConcurrentHashMap<>();

    private String key(String userId, String videoId) {
        return userId + "##" + videoId;
    }

    public Counts getCounts(String videoId) {
        VideoCounts vc = videoCounts.getOrDefault(videoId, new VideoCounts());
        return new Counts(vc.likes.get(), vc.dislikes.get());
    }

    public void react(String userId, String videoId, Reaction newReaction) {
        String uvKey = key(userId, videoId);
        VideoCounts counts = videoCounts.computeIfAbsent(videoId, id -> new VideoCounts());

        userVideo.compute(uvKey, (k, oldReaction) -> {
            Reaction oldR = (oldReaction == null) ? Reaction.NONE : oldReaction;

            if (oldR == newReaction) {
                return newReaction == Reaction.NONE ? null : newReaction;
            }

            // decreament old
            if (oldR == Reaction.LIKE)
                counts.likes.decrementAndGet();
            else if (oldR == Reaction.DISLIKE)
                counts.dislikes.decrementAndGet();

            // increament new
            if (newReaction == Reaction.LIKE)
                counts.likes.incrementAndGet();
            else if (newReaction == Reaction.DISLIKE)
                counts.dislikes.incrementAndGet();

            return newReaction == Reaction.NONE ? null : newReaction;

        });

    }

    public static class Counts {
        public final int likes;
        public final int dislikes;

        public Counts(int l, int d) {
            likes = l;
            dislikes = d;
        }

        @Override
        public String toString() {
            return "Likes = " + likes + ", Dislikes = " + dislikes;
        }
    }
}
