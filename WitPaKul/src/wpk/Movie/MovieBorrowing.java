
package wpk.Movie;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import wpk.Movie.Movie;
import wpk.account.MemberAccount;
import wpk.serviceITF.Specifications;
import wpk.Enum.AccountStatus;
import wpk.Enum.MovieStatus;

public class MovieBorrowing {

    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private Movie movieBorrow;
    private MemberAccount borrowAccount;
    private int fine;

    

    
    
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
        final MovieBorrowing other = (MovieBorrowing) obj;
        if (!Objects.equals(this.movieBorrow, other.movieBorrow)) {
            return false;
        }
        return true;
    }

    public int getFine(LocalDate returnDate) {
        if (returnDate.compareTo(dueDate) > 0) {
            long days = ChronoUnit.DAYS.between(dueDate, returnDate);
            return Specifications.FINE_PERDAYS * (int) days;
        }
        return 0;
    }

    public MovieBorrowing checkOutMovie(Movie borrowMovie, MemberAccount borrowAccount) {
        if (borrowAccount.getMemberStatus().equals(AccountStatus.MEMBER)) {
            this.borrowDate = LocalDate.now();
            this.dueDate = borrowDate.plus(Specifications.MAX_BORROWDAYS, ChronoUnit.DAYS);
            this.movieBorrow = borrowMovie;
            this.borrowAccount = borrowAccount;
            this.movieBorrow.setMovieStaus(MovieStatus.Borrowed);
            System.out.println("Set Compleate");
            return this;
        } else if (borrowAccount.getMemberStatus().equals(AccountStatus.PREMIUMMEMBER)) {
            this.borrowDate = LocalDate.now();
            this.dueDate = borrowDate.plus(Specifications.MAX_BORROWMOVIE_PREMIUMMEMBER, ChronoUnit.DAYS);
            this.movieBorrow = borrowMovie;
            this.borrowAccount = borrowAccount;
            this.movieBorrow.setMovieStaus(MovieStatus.Borrowed);
            return this;
        }
        return this;
    }

    public int returnMovie(MemberAccount borrowAccount) {
        this.borrowAccount = null;
        this.returnDate = LocalDate.now();
        this.fine = getFine(this.returnDate);
        this.movieBorrow.setMovieStaus(MovieStatus.Available);
        return this.fine;
    }

    @Override
    public String toString() {
        return "MovieName "+movieBorrow.getMovieTitle()
                + "\n BorrowDate = " + borrowDate 
                + "\n DueDate = " + dueDate 
                + "\n returnDate = "  + returnDate
                + "\n Movie = " + movieBorrow.getMovield()+" "+movieBorrow.getMovieTitle()
                + "\n Account = " +borrowAccount.getId() +" "+ borrowAccount.getFristname()+" "+borrowAccount.getLastname()
                + "\n Fine = " + fine ;
    }

    public MemberAccount getmyMovieborrowed() {
        return borrowAccount;
    }

    public Movie getMovieBorrow() {
        return movieBorrow;
    }

}
