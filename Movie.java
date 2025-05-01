public class Movie {
    public String name;
    public  String rating;
    public  int releaseYear;

    // Constructor to initialize movie details
    public Movie(String name, String rating, int releaseYear) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    // Getter for release year
    public int getReleaseYear() {
        return releaseYear;
    }

    // Display movie details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Rating: " + rating);
        System.out.println("Release Year: " + releaseYear);
        System.out.println(); // Adds a blank line for separation
    }

    public static void main(String[] args) {
        // Create 5 Movie objects
        Movie[] movies = {
            new Movie("Inception", "PG-13", 2010),
            new Movie("Avengers: Endgame", "PG-13", 2019),
            new Movie("Spider-Man: No Way Home", "PG-13", 2021),
            new Movie("Dune", "PG-13", 2021),
            new Movie("The Batman", "PG-13", 2022)
        };

        // Display movies released after 2020
        System.out.println("Movies released after 2020:");
        for (Movie movie : movies) {
            if (movie.getReleaseYear() > 2020) {
                movie.displayDetails();
            }
        }
    }
}