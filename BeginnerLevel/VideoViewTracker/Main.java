package VideoViewTracker;

public class Main {
    public static void main(String[] args) {
        VideoService service = new VideoService();

        // Add videos
        service.addVideo("V1", "Spring Boot Tutorial");
        service.addVideo("V2", "Kubernetes Deep Dive");

        // Users view videos
        service.viewVideo("U1", "V1");
        service.viewVideo("U2", "V1");
        service.viewVideo("U1", "V1"); // same user again
        service.viewVideo("U3", "V1");
        service.showVideoStats("V1"); // Total: 4, Unique: 3

        // Views for another video
        service.viewVideo("U1", "V2");
        service.viewVideo("U2", "V2");
        service.showVideoStats("V2"); // Total: 2, Unique: 2

        // Invalid video
        service.viewVideo("U1", "V99");
    }
}

