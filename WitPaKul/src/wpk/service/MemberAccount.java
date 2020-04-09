package wpk.service;
import java.time.LocalDate;
import wpk.account.Account;
import wpk.person.Person;
/**
 *
 * @author Sathipp
 */
public abstract class MemberAccount extends Account{
    private borrowingMovie[] MovieBorrowing = new borrowingMovie[Policy.MAX_BORROWMOVIE_MEMBER] ;
    private int totalBorrowMovie = 0;
    private int overDue = 0;
    
    public MemberAccount(String id, String password, Person person) {
        super(id, password, person);
    }

    public MemberAccount(Account account) {
        super(account);
    }
    
    boolean checkoutItem(Movie borrowMovie) {
        if (borrowMovie != null) {
            this.MovieBorrowing[totalBorrowMovie++] = borrowMovie;
            return true;
        } else {
            return false;
        }
    }
    
    public int getTotalMoviecheckedOut() {
        return totalBorrowMovie;
    }

    MovieBrrowing[] getMovieBorrowList() {
        return this.MovieBorrowing;
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
    
    int checkForFine(MovieBorrowing borrowedMovie){
        return borrowedMovie.getFine(LocalDate.now());
    }
}
