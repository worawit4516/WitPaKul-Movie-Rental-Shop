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
    private int price;

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
        if (borrowAccount.getMemberStatus().equals(AccountStatus.MEMBER) && borrowMovie.getMovieStatus().equals(MovieStatus.Available) ) {
            this.borrowDate = LocalDate.now();
            this.dueDate = borrowDate.plus(Specifications.MAX_BORROWDAYS, ChronoUnit.DAYS);
            this.movieBorrow = borrowMovie;
            this.borrowAccount = borrowAccount;
            this.movieBorrow.setMovieStatus(MovieStatus.Borrowed);
            this.price = borrowMovie.getPrice();
           
            return this;
        }
        if (borrowAccount.getMemberStatus().equals(AccountStatus.PREMIUMMEMBER) && borrowMovie.getMovieStatus().equals(MovieStatus.Available)) {
            this.borrowDate = LocalDate.now();
            this.dueDate = borrowDate.plus(Specifications.MAX_BORROWDAYS_PREMIUM, ChronoUnit.DAYS);
            this.movieBorrow = borrowMovie;
            this.borrowAccount = borrowAccount;
            this.movieBorrow.setMovieStatus(MovieStatus.Borrowed);
            this.price = borrowMovie.getPrice();
            
            return this;
        }

        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plus(Specifications.MAX_BORROWDAYS_PREMIUM, ChronoUnit.DAYS);
        this.movieBorrow = borrowMovie;
        this.borrowAccount = borrowAccount;
        this.movieBorrow.setMovieStatus(MovieStatus.Borrowed);
        this.price = borrowMovie.getPrice();
        

        return this;
    }

    public int returnMovie(MemberAccount borrowAccount) {
        this.borrowAccount = null;
        this.returnDate = LocalDate.now();
        this.fine = getFine(this.returnDate);
        this.movieBorrow.setMovieStatus(MovieStatus.Available);
        return this.fine;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append(" Borrow date: " + borrowDate);
        str.append("\n Due date:    " + dueDate);
        str.append("\r\n");
        str.append("\n Movie:  " + movieBorrow.getMovield() + " " + movieBorrow.getMovieTitle());
        if (borrowAccount != null) {
        str.append("\n Member: " + borrowAccount.getId() + " " + borrowAccount.getFirstname() + " " + borrowAccount.getLastname());
        }

        str.append("\r\n");
        str.append("--------------------------------------");
        str.append("\n                    Price: " + price);
        str.append("\n                    Fine:  ").append(fine);

        str.append("\r\n");
        str.append("---------------------------------------");
        str.append("\r\n");
        if (returnDate != null) {
            str.append("\n Date:  " + returnDate);
        }

        return str.toString();
    }

    public MemberAccount getmyMovieborrowed() {
        return borrowAccount;
    }

    public Movie getMovieBorrow() {
        return movieBorrow;
    }

    public int getPrice() {
        return price;
    }

}
