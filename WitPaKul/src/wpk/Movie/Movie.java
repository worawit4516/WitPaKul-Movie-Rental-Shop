package wpk.Movie;

import wpk.Enum.MovieStatus;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Movie {

    private String movield;
    private String movieTitle;
    private MovieStatus movieStatus;
    private int premiumStatus = 0;

    public Movie(String movield, String movieTitle, int premiumStatus, MovieStatus mos) {
        this.movield = movield;
        this.movieTitle = movieTitle;
        this.movieStatus= mos;
        this.premiumStatus = premiumStatus;
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
        return "Movie" + " Movield " + movield + ", movieTitle=" + movieTitle + ", movieStatus=" + movieStatus + " " + premiumStatus;
    }

}
