package JavaProject;
import java.util.*;

class InvalidSeatException extends Exception {
    public InvalidSeatException(String message) {
        super(message);
    }
}
class Movie implements Comparable<Movie> {

    private int movieId;
    private String movieName;
    private double ticketPrice;

    public Movie(int movieId, String movieName, double ticketPrice) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
    }
    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public int compareTo(Movie m) {
        return this.movieName.compareTo(m.movieName);
    }

    @Override
    public String toString() {
        return movieId + " | " + movieName + " | ₹" + ticketPrice;
    }
}
public class MovieTicketBookingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie(101, "Pushpa 2", 250));
        movies.add(new Movie(102, "Kalki", 300));
        movies.add(new Movie(103, "Leo", 220));
        movies.add(new Movie(104, "Jawan", 280));

        Collections.sort(movies);

        System.out.println("===== AVAILABLE MOVIES =====");

        for(Movie m : movies) {
            System.out.println(m);
        }
        try {

            System.out.print("\nEnter Movie ID: ");
            int movieId = sc.nextInt();

            Movie selectedMovie = null;

            for (Movie m : movies) {
                if (m.getMovieId() == movieId) {
                    selectedMovie = m;
                    break;
                }
            }

            if (selectedMovie == null) {
                throw new InvalidSeatException("Movie Not Found!");
            }

            System.out.print("Enter Number of Seats: ");
            int seats = sc.nextInt();

            if (seats <= 0) {
                throw new InvalidSeatException(
                        "Invalid Number Of Seats!"
                );
            }

            double total =
                    selectedMovie.getTicketPrice() * seats;

            System.out.println("\n===== BOOKING CONFIRMED =====");
            System.out.println("Movie : "
                    + selectedMovie.getMovieName());

            System.out.println("Seats : " + seats);

            System.out.println("Total Amount : ₹" + total);
        }
        catch(InvalidSeatException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("\nThank You For Booking!");
        }
        sc.close();
    }
}