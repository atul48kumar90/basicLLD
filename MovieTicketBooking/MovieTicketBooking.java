// package MovieTicketBooking;

// public class MovieTicketBooking {
//     public static void main(String[] args) {
//         MovieTicketService service = new MovieTicketService();

//         // Add movies
//         service.addMovie("M1", "Inception");
//         service.addMovie("M2", "Interstellar");

//         // Add shows
//         service.addShow("S1", "M1", 5);
//         service.addShow("S2", "M2", 3);

//         // Book tickets
//         service.bookTickets("S1", 2);
//         service.bookTickets("S1", 3);
//         service.showStats("S1"); // Total: 5, Booked: 5, Available: 0

//         // Try booking more
//         service.bookTickets("S1", 1); // Not enough seats

//         // Cancel some tickets
//         service.cancelTickets("S1", 2);
//         service.showStats("S1"); // Available: 2

//         // Check another show
//         service.bookTickets("S2", 1);
//         service.showStats("S2");
//     }
// }
