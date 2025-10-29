package MovieTicketBooking;

import java.util.HashMap;
import java.util.Map;

public class MovieTicketService {
    Map<String, Movie> movies = new HashMap<>();
    Map<String, Show> shows = new HashMap<>();

    public void addMovie(String id, String name){
        movies.put(id, new Movie(id, name));
    }

    public void addShow(String showId, Movie movie, int capacity){
        shows.put(showId, new Show(showId, movie, capacity));
    }

    public void bookTicket(String showId, int count){
        Show show = shows.get(showId);
        show.bookTicket(count);
    }

    public void cancelTickets(String showId, int count) {
        Show show = shows.get(showId);
        if (show == null) {
            System.out.println("❌ Show not found");
            return;
        }

        if (show.cancelTicket(count)) {
            System.out.println("🔄 Canceled " + count + " tickets for " + show.movie.title);
        } else {
            System.out.println("⚠️ Cannot cancel that many tickets.");
        }
    }

    public void showStats(String showId) {
        Show show = shows.get(showId);
        if (show == null) {
            System.out.println("❌ Show not found");
            return;
        }
        System.out.println("🎥 " + show.movie.title + " | Total: " + show.totalTicket +
                ", Booked: " + show.bookedTicket +
                ", Available: " + show.getAvailableSeats());
    }
}
