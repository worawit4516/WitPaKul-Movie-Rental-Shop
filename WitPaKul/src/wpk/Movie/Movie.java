/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpk.Movie;

import Enum.MovieStatus;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Movie {

    private String movield;
    private String movieTitle;
    private MovieStatus movieStaus;
    private int premiumStatus = 1;

    public Movie(String movield, String movieTitle,int premiumStatus,MovieStatus mos) {
        this.movield = movield;
        this.movieTitle = movieTitle;
        this.movieStaus = mos;
        this.premiumStatus=premiumStatus;
    }

    public String getMovield() {
        return movield;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public MovieStatus getMovieStaus() {
        return movieStaus;
    }

    public void setMovieStaus(MovieStatus movieStaus) {
        this.movieStaus = movieStaus;
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
        if (this.movieStaus != other.movieStaus) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movie" + " Movield " + movield + ", movieTitle=" + movieTitle + ", movieStaus=" + movieStaus + ", premiumStatus=" + premiumStatus ;
    }

    
    
}
