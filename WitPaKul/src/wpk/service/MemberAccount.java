package wpk.service;
import java.time.LocalDate;
import wpk.Store.MovieBorrowing;
import wpk.account.Account;
import wpk.person.Person;
import wpk.Store.Specifications;
import wpk.Movie.Movie;
/**
 *
 * @author Sathipp
 */
public class MemberAccount extends Account{
    private MovieBorrowing borrowingMovie[]  = new MovieBorrowing[Specifications.MAX_BORROWMOVIE_MEMBER] ;
    private int totalBorrowMovie = 0;
    private int overDue = 0;
    
    public MemberAccount(String id, String password, Person person) {
        super(id, password, person);
    }

    public MemberAccount(Account account) {
        super(account);
    }

   
    
    boolean checkoutItem(MovieBorrowing borrowMovie) {
        if (borrowMovie != null) {
            borrowingMovie[totalBorrowMovie++] = borrowMovie;
            return true;
        } else {
            return false;
        }
    }
    
    public int getTotalMoviecheckedOut() {
        return totalBorrowMovie;
    }

    public MovieBorrowing getMovieBorrowList() {
        int i = 0;
        return this.borrowingMovie[i];
    }

    int check(MovieBorrowing movie) {
        for (int i = 0; i < totalBorrowMovie; i++) {
            if (borrowingMovie[i].equals(movie)) {
                return i;
            }
        }
        return -1;
    }
    
    void remove(int index){
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
    
    public  int checkForFine(MovieBorrowing borrowedMovie){
        return borrowedMovie.getFine(LocalDate.now());
    }
}
