package lib.service;

import java.util.Iterator;
import lib.account.Account;
import lib.item.Book;
import lib.item.Item;
import lib.item.ItemStatus;
import lib.policy.Policy;

public class Library implements Policy, LibrarianService, MemberService {

    private String libraryName;
    private MemberAccount members[];
    private LibrarianAccount librarian;
    private Item libraryItems[];
    private ItemLending libraryLendingItems[];
    private int countLib = 0, countLend = 0, countMem = 0;

    public Library(String libraryName, LibrarianAccount librarian, int maxItem, int maxMember, int maxLendingItem) {
        this.libraryName = libraryName;
        this.libraryLendingItems = new ItemLending[maxLendingItem];
        this.members = new MemberAccount[maxMember];
        this.libraryItems = new Item[maxItem];
        this.librarian = librarian;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < libraryItems.length;
            }

            @Override
            public Item next() {
                return libraryItems[counter++];
            }
        };
    }

    private int check(Object obj) {
        if (obj instanceof Item) {
            for (int i = 0; i < countLib; i++) {
                if (libraryItems[i].equals(obj)) {
                    return i;
                }
            }
            return -1;
        } else if (obj instanceof ItemLending) {
            for (int i = 0; i < countLend; i++) {
                if (libraryLendingItems[i].equals(obj)) {
                    return i;
                }
            }
            return -1;
        } else if (obj instanceof MemberAccount) {
            for (int i = 0; i < countMem; i++) {
                if (members[i].equals(obj)) {
                    return i;
                }
            }
            return -1;
        } else {
            return -2;
        }
    }
    
    private void remove(Object obj) {
        if (obj instanceof Item) {
            for (int i = check(obj); i < countLib; i++) {
                    if (i == countLib - 1) {
                        libraryItems[i] = null;
                    } else {
                        libraryItems[i] = libraryItems[i + 1];
                    }
                }
            countLib--;
        } else if (obj instanceof ItemLending) {
            for (int i = check(obj); i < countLend; i++) {
                    if (i == countLend - 1) {
                        libraryLendingItems[i] = null;
                    } else {
                        libraryLendingItems[i] = libraryLendingItems[i + 1];
                    }
                }
            countLend--;
        } else if (obj instanceof MemberAccount) {
            for (int i = check(obj); i < countMem; i++) {
                    if (i == countMem - 1) {
                        members[i] = null;
                    } else {
                        members[i] = members[i + 1];
                    }
                }
            countMem--;
        }
    }

    @Override
    public boolean addItem(LibrarianAccount librarian, Item item) {
        if (librarian.equals(this.librarian)) {
            if (check(item) == -1 && countLib < libraryItems.length) {
                this.libraryItems[countLib++] = item;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean addMember(LibrarianAccount librarian, Account member) {
        if (librarian.equals(this.librarian)) {
            MemberAccount newMem = new MemberAccount(member);
            if (check(newMem) == -1 && countMem < members.length) {
                this.members[countMem++] = newMem;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public ItemLending checkoutItem(MemberAccount member, Item borrowBook) {
        if (check(member) >= 0) {
            if (member.getTotalItemsCheckedOut() < Policy.MAX_LENDING_BOOKS && borrowBook.getItemStatus() == ItemStatus.AVAILABLE) {
                if (borrowBook instanceof Book) {
                    Book book = (Book) borrowBook;
                    ItemLending checkedBook = new BookLending();
                    checkedBook.checkoutItem(book, member);
                    libraryLendingItems[countLend++] = checkedBook;
                    return checkedBook;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public int checkForFine(MemberAccount member, ItemLending borrowItem) {
        if (check(member) >= 0) {
            return member.checkForFine(borrowItem);
        } else {
            return -1;
        }
    }

    @Override
    public boolean returnItem(MemberAccount member, ItemLending returnItem) {
        if (check(member) >= 0) {
            if (returnItem.getLendingMember().equals(member)) {
                int fine = returnItem.returnItem(member);
                remove(returnItem);
                if (fine > 0) {
                    System.out.println("Your fine is " + fine + " Baht.");
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public ItemLending[] getMyLendingList(MemberAccount member) {
        if (check(member) >= 0) {
            return member.getMyLendingList();
        } else {
            return null;
        }
    }

}
