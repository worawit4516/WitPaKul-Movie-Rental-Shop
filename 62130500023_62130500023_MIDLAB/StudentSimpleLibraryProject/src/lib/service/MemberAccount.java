package lib.service;

import java.time.LocalDate;
import java.util.Objects;
import lib.account.Account;
import lib.person.Person;
import lib.policy.Policy;

public class MemberAccount extends Account {

    private ItemLending[] myLendingItems = new ItemLending[Policy.MAX_LENDING_BOOKS];
    private int totalItemsCheckedOut = 0;
    private int overdueCount = 0;

    public MemberAccount(String id, String password, Person person) {
        super(id, password, person);
    }

    public MemberAccount(Account account) {
        super(account);
    }

    boolean checkoutItem(ItemLending borrowItem) {
        if (borrowItem != null) {
            this.myLendingItems[totalItemsCheckedOut++] = borrowItem;
            return true;
        } else {
            return false;
        }
    }
    
    public int getTotalItemsCheckedOut() {
        return totalItemsCheckedOut;
    }

    ItemLending[] getMyLendingList() {
        return this.myLendingItems;
    }

    int check(ItemLending item) {
        for (int i = 0; i < totalItemsCheckedOut; i++) {
            if (myLendingItems[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    
    void remove(int index){
        for (int i = index; i < totalItemsCheckedOut; i++) {
                    if (i == totalItemsCheckedOut - 1) {
                        myLendingItems[i] = null;
                    } else {
                        myLendingItems[i] = myLendingItems[i + 1];
                    }
                }
    }

    void returnItem(ItemLending lendingItem, int fine) {
        int returnItem = check(lendingItem);
        if (returnItem >= 0) {
            remove(returnItem);
            this.totalItemsCheckedOut--;
            if (fine > 0) {
                this.overdueCount++;
            }
        }
    }
    
    int checkForFine(ItemLending borrowItem){
        return borrowItem.getFine(LocalDate.now());
    }
}
