package MovieTicketBooking;

public class Show {
    private final String showId;
    final Movie movie;
     final int totalTicket;
     int bookedTicket;

    public Show(String showId, Movie movie, int totalTicket){
        this.showId = showId;
        this.movie = movie;
        this.totalTicket = totalTicket;
        this.bookedTicket = 0;
    }

    public String getShow(){
        return showId;
    }

    public int getAvailableSeats(){
        return totalTicket - bookedTicket;
    }

    public boolean bookTicket(int count){
        if(bookedTicket + count > totalTicket){
            System.out.println("not enough seat available");
            return false;
        }
        bookedTicket = bookedTicket + count;
        return true;
    }

    public boolean cancelTicket(int count){
        if(bookedTicket < count){
            System.out.println(" can't cancel more than booked");
            return false;
        }
        bookedTicket -= count;
        return true;
    }
}
