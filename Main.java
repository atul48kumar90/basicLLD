public class Main {
    public static void main(String[] args) {
        YoutubeLikeDislike service = new YoutubeLikeDislike();

        String videoId = "v101";

        //user react
        service.react("u1", videoId, Reaction.LIKE);
        service.react("u2", videoId, Reaction.LIKE);
        service.react("u3", videoId, Reaction.DISLIKE);

        System.out.println("After initial reactions:");
        System.out.println(service.getCounts(videoId));

        // User u1 changes like -> dislike
        service.react("u1", videoId, Reaction.DISLIKE);
        System.out.println("\nAfter u1 changes like -> dislike:");
        System.out.println(service.getCounts(videoId));

        // User u2 unlikes (goes to NONE)
        service.react("u2", videoId, Reaction.NONE);
        System.out.println("\nAfter u2 removes reaction:");
        System.out.println(service.getCounts(videoId));

        // Idempotent checks (same reaction again)
        service.react("u3", videoId, Reaction.DISLIKE);
        System.out.println("\nAfter u3 repeats DISLIKE (no change):");
        System.out.println(service.getCounts(videoId));

        // Add more reactions
        service.react("u4", videoId, Reaction.LIKE);
        service.react("u5", videoId, Reaction.LIKE);
        System.out.println("\nAfter u4 and u5 like:");
        System.out.println(service.getCounts(videoId));
    }
}
