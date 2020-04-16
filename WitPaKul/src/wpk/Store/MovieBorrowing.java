/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpk.Store;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import wpk.Movie.Movie;
import wpk.account.Account;
import wpk.service.EmployeeAccount;
import wpk.service.MemberAccount;
import wpk.Store.MovieStore;

public class MovieBorrowing {

    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private Movie movieBorrow;
    private MemberAccount borrowAccount;
    private int fine;

    public MovieBorrowing(LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate, Movie movieBorrow, MemberAccount borrowAccount, int fine) {
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.movieBorrow = movieBorrow;
        this.borrowAccount = borrowAccount;
        this.fine = fine;
    }


    public int getFine(LocalDate returnDate) {
        if (returnDate.compareTo(dueDate) > 0) {
            long days = ChronoUnit.DAYS.between(dueDate, returnDate);
            //return  * (int) days;
        }
        return 0;
    }
    public MovieBorrowing checkOutIItem(Movie borrowMovie,MemberAccount borrowAccount){
        this.borrowDate = LocalDate.of(2020, Month.FEBRUARY, 20);
        //this.borrowDate = LocalDate.now;
      //  this.dueDate = borrowDate.plus();
       // this.lendingItem = borrowItem;
       // this.lendingMember = lendingMember;
      //  this.lendingItem.setItemStatus();
        return this; 
    }
    public  int returnMovie(MemberAccount borrowAccount){
        this.borrowAccount = null;
        this.returnDate = LocalDate.now();
        this.fine = getFine(this.returnDate);
        // this.lendingItem.setItemStatus(ItemStatus.AVAILABLE);
        return this.fine;
    }
  
}
