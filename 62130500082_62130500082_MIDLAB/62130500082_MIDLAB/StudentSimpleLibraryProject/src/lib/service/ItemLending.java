package lib.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import lib.account.Account;
import lib.item.Item;
import lib.item.ItemStatus;
import lib.policy.Policy;

public abstract class ItemLending {

    LocalDate borrowDate;
    LocalDate dueDate;
    LocalDate returnDate;
    Item lendingItem;
    Account lendingMember;
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
        final ItemLending other = (ItemLending) obj;
        if (this.fine != other.fine) {
            return false;
        }
        if (!Objects.equals(this.borrowDate, other.borrowDate)) {
            return false;
        }
        if (!Objects.equals(this.dueDate, other.dueDate)) {
            return false;
        }
        if (!Objects.equals(this.returnDate, other.returnDate)) {
            return false;
        }
        if (!Objects.equals(this.lendingItem, other.lendingItem)) {
            return false;
        }
        if (!Objects.equals(this.lendingMember, other.lendingMember)) {
            return false;
        }
        return true;
    }

    int getFine(LocalDate returnDate) {
        if (returnDate.compareTo(dueDate) > 0) {
            long days = ChronoUnit.DAYS.between(dueDate, returnDate);
            return Policy.FINE_PER_DAY * (int) days;
        }
        return 0;
    }
    //LocalDate.now()
    //this.borrowDate = LocalDate.of(2020, Month.FEBRUARY,20 );
    //this.dueDate = borrowDate.plus(Policy.MAX_LENDING_DAYS, ChronoUnit.DAYS);

    ItemLending checkoutItems(Item borrowItems, MemberAccount lendingMember) {
        
        this.lendingItem = borrowItems;
        this.borrowDate =  LocalDate.of(2020, Month.FEBRUARY,20 );
        this.dueDate = borrowDate.plus(Policy.MAX_LENDING_DAYS, ChronoUnit.DAYS);
        this.lendingMember=(MemberAccount)lendingMember;
        lendingItem.setItemStatus(ItemStatus.BORROWED);
        return null;
    }

    int returnItem(MemberAccount lendingMember) {
        if (this.lendingMember.equals(lendingMember)) {
            returnDate = LocalDate.now();
            getFine(returnDate);
            lendingItem.setItemStatus(ItemStatus.AVAILABLE);
        }

        return 0;
    }

}
