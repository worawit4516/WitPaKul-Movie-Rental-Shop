package wpk.Movie;

import wpk.Enum.MovieStatus;
import java.util.Objects;
import wpk.serviceITF.Specifications;

/**
 *
 * @author user
 */
public class Movie {

    private String movield;
    private int Price;
    private String movieTitle;
    private MovieStatus movieStatus;
    private int premiumStatus = 0;

    public Movie(String movield, String movieTitle, int premiumStatus, MovieStatus movieStatus) {
        this.movield = movield;
        this.movieTitle = movieTitle;
        this.movieStatus = movieStatus;
        this.premiumStatus = premiumStatus;
        if (premiumStatus == 1) {
            this.Price = Specifications.PremiumMovie_Price;
        }
        if (premiumStatus != 1) {
            this.Price = Specifications.Movie_Price;
        }

    }

    public String getMovield() {
        return movield;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public MovieStatus getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(MovieStatus movieStatus) {
        this.movieStatus = movieStatus;
    }

    public int getPremiumStatus() {
        return premiumStatus;
    }

    public void setMovield(String movield) {
        this.movield = movield;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setPremiumStatus(int premiumStatus) {
        this.premiumStatus = premiumStatus;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getPrice() {
        return Price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.movield, other.movield)) {
            return false;
        }
        if (!Objects.equals(this.movieTitle, other.movieTitle)) {
            return false;
        }
        if (!Objects.equals(this.premiumStatus, other.premiumStatus)) {
            return false;
        }
        if (this.movieStatus != other.movieStatus) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movie" + " Movield " + movield + ", movieTitle=" + movieTitle + ", Price " + Price + ", movieStatus=" + movieStatus + " " + premiumStatus;
    }

}
