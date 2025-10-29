package YTLikeNDISLIKE;

import java.util.concurrent.atomic.AtomicInteger;

public class VideoCounts {
    final AtomicInteger likes = new AtomicInteger(0);
    final AtomicInteger dislikes = new AtomicInteger(0);

    @Override
    public String toString() {
        return "Likes = " + likes.get() + ", Dislikes = " + dislikes.get();
    }
}
