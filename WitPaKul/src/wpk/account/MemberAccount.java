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
public class MemberAccount {

    private MovieBorrowing borrowingMovie[] = new MovieBorrowing[Specifications.MAX_BORROWMOVIE_MEMBER];
    private int totalBorrowMovie = 0;
    private int overDue = 0;
    private AccountMovieStatus memberMovieStatus;
    private Account account;
    
    public MemberAccount(Account account) {
          if (checkstatus(account)) {
            this.account = account;
            System.out.println("Setaccount Complate");
        } else {
            System.out.println("Can't Set this account");
        }
    }
    
    public AccountMovieStatus getAccountMovieStatus() {
        return memberMovieStatus.ACTIVEB;
    }
    
    public void setMemberMovieStatus(AccountMovieStatus memberMovieStatus) {
        this.memberMovieStatus = memberMovieStatus;
    }
    
    public AccountStatus getMemberStatus() {
        return account.getStatus();
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
    
    boolean checkoutMovie(MovieBorrowing borrowMovie) {
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
                borrowingMovie[i] = null;
            } else {
                borrowingMovie[i] = borrowingMovie[i + 1];
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
        if (account.getStatus().equals(AccountStatus.MEMBER)) {
            return true;
        }
        return false;
    }

}
