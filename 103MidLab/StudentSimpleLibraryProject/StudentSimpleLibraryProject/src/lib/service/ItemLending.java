package lib.service;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import lib.account.Account;
import lib.item.Item;
import lib.policy.Policy;

public abstract class ItemLending {
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private Item lendingItem;
    private Account lendingMember;
    private int fine;

    //LocalDate.now()
    //this.borrowDate = LocalDate.of(2020, Month.FEBRUARY,20 );
    //this.dueDate = borrowDate.plus(Policy.MAX_LENDING_DAYS, ChronoUnit.DAYS);
    
    int getFine(LocalDate returnDate) {
        if (returnDate.compareTo(dueDate) > 0) {
            long days = ChronoUnit.DAYS.between(dueDate, returnDate);
            return Policy.FINE_PER_DAY * (int) days;
        }
        return 0;
    }
}
