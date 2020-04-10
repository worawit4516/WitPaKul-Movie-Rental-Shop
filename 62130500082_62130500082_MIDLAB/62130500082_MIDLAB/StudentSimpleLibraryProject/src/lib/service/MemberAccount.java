package lib.service;

import java.time.LocalDate;
import lib.account.Account;

public class MemberAccount extends lib.account.Account {

    private ItemLending myLendingitems[];
    private int totalItemsCheckedout;
    private int overdueCount;

    public MemberAccount(Account account) {
        super(account);
    }

    boolean checkoutItem(ItemLending borrowItem) {
        for (int i = 0; i < myLendingitems.length; i++) {
            myLendingitems[i] = borrowItem;
         }
        return  true;
    }

    public ItemLending[] getMyLendingitems() {
        return myLendingitems;
    }

    void returnItem(ItemLending itemLending, int fine) {
        ItemLending[] temp = myLendingitems;
        for (int i = 0; i < myLendingitems.length; i++) {
            if (myLendingitems[i].equals(itemLending)) {
                myLendingitems[i] = null;
            }
            System.arraycopy(myLendingitems, 0, temp, 0, i);
            myLendingitems = temp;

            if (fine > 0) {
                overdueCount++;
            }

        }

    }

    int checkForfire(ItemLending borrowItem) {
        int fine;
        for (int i = 0; i < myLendingitems.length; i++) {
            if (myLendingitems[i].equals(borrowItem)) {
                fine = myLendingitems[i].getFine(LocalDate.MIN);
                return fine;
            }

        }
        return 0;
    }

}
