package MovieTicketBooking;

public class Movie {
    private final String id;
    final String title;

    public Movie(String id, String title){
        this.id = id;
        this.title = title;
    }

    public String getMovieId(){ return id; }
    public String getTitle(){ return title; }
}
