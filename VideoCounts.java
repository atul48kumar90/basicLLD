import java.util.concurrent.atomic.AtomicInteger;

public class VideoCounts {
    final AtomicInteger likes = new AtomicInteger(0);
    final AtomicInteger dislikes = new AtomicInteger(0);

    @Override
    public String toString() {
        return "likes = " + likes.get() + ", Dislikes = " + dislikes.get();
    }
}
