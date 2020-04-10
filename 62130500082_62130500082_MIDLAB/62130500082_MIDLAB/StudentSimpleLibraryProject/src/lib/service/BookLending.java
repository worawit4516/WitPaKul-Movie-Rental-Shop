package lib.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import lib.item.Item;
import lib.item.ItemStatus;
import lib.policy.Policy;

public class BookLending extends ItemLending {

    @Override
    ItemLending checkoutItems(Item borrowItems, MemberAccount lendingMember) {
        this.lendingItem = borrowItems;
        this.borrowDate =  LocalDate.of(2020, Month.FEBRUARY,20 );
        this.lendingMember=(MemberAccount)lendingMember;
        this.dueDate = borrowDate.plus(Policy.MAX_LENDING_DAYS, ChronoUnit.DAYS);
        lendingItem.setItemStatus(ItemStatus.BORROWED);
        return null;
    }

    @Override
    int returnItem(MemberAccount lendingMember) {
        if (this.lendingMember.equals(lendingMember)) {
            returnDate = LocalDate.now();
            getFine(returnDate);
            lendingItem.setItemStatus(ItemStatus.AVAILABLE);
        }

        return 0;
    }
}
