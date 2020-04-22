package wpk.account;

import java.time.LocalDate;
import wpk.Store.MovieBorrowing;
import wpk.account.Account;
import wpk.service.Specifications;
import wpk.Movie.Movie;
import wpk.account.AccountStatus;
import Enum.AccountMovieStatus;
import Enum.AccountMovieStatus;

/**
 *
 * @author Sathipp
 */
public class MemberAccount extends Account {

    private MovieBorrowing borrowingMovie[];
    private int totalBorrowMovie = 0;
    private int overDue = 0;
    private AccountMovieStatus memberMovieStatus;
    private AccountStatus status;

    public MemberAccount(String id, String fristname, String lastname, String password, long phone, AccountStatus status, AccountMovieStatus acstatus) {
        super(id, fristname, lastname, password, phone, status);
        this.setMemberMovieStatus(acstatus);
        this.status = status;
    }

    public void editDataMember(String fristname, String lastname, String password, long phone, AccountStatus status, AccountMovieStatus acstatus) {
        this.setFristname(fristname);
        this.setLastname(lastname);
        this.setPassword(password);
        this.setPhone(phone);
        this.setStatus(status);
        this.setMemberMovieStatus(acstatus);

    }

    @Override
    public String toString() {
        return super.toString() + " AccountMovieStatus " + memberMovieStatus;
    }

    public void setMaxBorrowMovie(AccountStatus status) {

        if (status.MEMBER.equals(AccountStatus.MEMBER)) {
            this.borrowingMovie = new MovieBorrowing[Specifications.MAX_BORROWMOVIE_MEMBER];
        } else if (status.PREMIUMMEMBER.equals(AccountStatus.PREMIUMMEMBER)) {
            this.borrowingMovie = new MovieBorrowing[Specifications.MAX_BORROWMOVIE_PREMIUMMEMBER];

        }
        if (AccountStatus.MEMBER != status || AccountStatus.PREMIUMMEMBER != status) {
            System.out.println("Cannot Create MemberAccount !");
        }

    }

    public AccountMovieStatus getAccountMovieStatus() {
        return memberMovieStatus;
    }

    public void setMemberMovieStatus(AccountMovieStatus memberMovieStatus) {
        this.memberMovieStatus = memberMovieStatus;
    }

    public AccountStatus getMemberStatus() {
        return status;
    }

    public int getTotalMoviecheckedOut() {
        return totalBorrowMovie;
    }

    public int getMovieBorrowList() {
        for (int i = 0; i < totalBorrowMovie; i++) {

            if (borrowingMovie[i] != null) {
                System.out.println(borrowingMovie[i]);
            }

        }
        return -1;
    }
//     public MovieBorrowing[] getMovieBorrowList2() {
//        for (int i = 0; i < borrowingMovie.length; i++) {
//            
//            if (borrowingMovie[i] != null) {
//                System.out.println(borrowingMovie[i]);
//            }
//            
//        }
//        return borrowingMovie;
//    }

    public boolean checkoutMovie(MovieBorrowing borrowMovie) {
        if (borrowMovie != null) {
            borrowingMovie[totalBorrowMovie++] = borrowMovie;
            return true;
        } else {
            return false;
        }
    }

    int check(MovieBorrowing movie) {
        for (int i = 0; i < totalBorrowMovie; i++) {
            if (borrowingMovie[i].equals(movie)) {
                return i;
            }
        }
        return -1;
    }

    void remove(int index) {
        for (int i = index; i < totalBorrowMovie; i++) {
            if (i == totalBorrowMovie - 1) {
                for (int j = i + 1; j < totalBorrowMovie; j++) {
                    borrowingMovie[i] = borrowingMovie[j];
                }
                borrowingMovie[--totalBorrowMovie] = null;
            }

        }
    }

    void returnMovie(MovieBorrowing borrowingMovie, int fine) {
        int returnMovie = check(borrowingMovie);
        if (returnMovie >= 0) {
            remove(returnMovie);
            this.totalBorrowMovie--;
            if (fine > 0) {
                this.overDue++;
            }
        }
    }

    public int checkForFine(MovieBorrowing borrowedMovie) {
        return borrowedMovie.getFine(LocalDate.now());
    }

    public boolean checkstatus(Account account) {
        if (account.getStatus().equals(AccountStatus.MEMBER) || account.getStatus().equals(AccountStatus.PREMIUMMEMBER)) {
            return true;
        }
        return false;
    }

}
