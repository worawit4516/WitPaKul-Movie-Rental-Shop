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

    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private Item lendingItem;
    private Account lendingMember;
    private int fine;

    int getFine(LocalDate returnDate) {
        if (returnDate.compareTo(dueDate) > 0) {
            long days = ChronoUnit.DAYS.between(dueDate, returnDate);
            return Policy.FINE_PER_DAY * (int) days;
        }
        return 0;
    }

    ItemLending checkoutItem(Item borrowItem, MemberAccount lendingMember) {
        this.borrowDate = LocalDate.of(2020, Month.FEBRUARY, 20);
        //this.borrowDate = LocalDate.now;
        this.dueDate = borrowDate.plus(Policy.MAX_LENDING_DAYS, ChronoUnit.DAYS);
        this.lendingItem = borrowItem;
        this.lendingMember = lendingMember;
        this.lendingItem.setItemStatus(ItemStatus.BORROWED);
        return this;
    }

    int returnItem(MemberAccount lendingMember) {
        this.lendingMember = null;
        this.returnDate = LocalDate.now();
        //this.returnDate = LocalDate.of(2020, Month.FEBRUARY, 21);
        this.fine = getFine(this.returnDate);
        this.lendingItem.setItemStatus(ItemStatus.AVAILABLE);
        return this.fine;
    }

    @Override
    public String toString() {
        return "ItemLending{" + "borrowDate=" + borrowDate + ", dueDate=" + dueDate + ", lendingItem=" + lendingItem + ", lendingMember=" + lendingMember + '}';
    }

    public Account getLendingMember() {
        return lendingMember;
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
        final ItemLending other = (ItemLending) obj;
        if (!Objects.equals(this.lendingItem, other.lendingItem)) {
            return false;
        }
        return true;
    }
}
