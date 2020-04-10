package lib.service;

import java.time.LocalDate;
import lib.account.Account;
import lib.item.Item;
import java.util.Iterator;

public class Library implements LibrarianService, MemberService, lib.policy.Policy {
    
    private String libraryName;
    private MemberAccount members[];
    private LibrarianAccount librarian;
    private Item libraryItems[];
    private ItemLending libraryLendingItems[];
    private int countlibraryItems;
    private int countItemLending;
    private int countImembers;
    
    public Library(String libraryName, LibrarianAccount librarian, int maxItem, int maxMember, int maxLendingItem) {
        this.libraryName = libraryName;
        this.libraryLendingItems = new ItemLending[maxLendingItem];
        this.members = new MemberAccount[maxMember];
        this.libraryItems = new Item[maxItem];
        this.librarian = librarian;
    }
    
    @Override
    public boolean addItem(LibrarianAccount librarian, Item item) {
        
        if (this.librarian.equals(librarian)) {
            for (int i = 0; i < countlibraryItems; i++) {
                if (libraryItems[i].equals(item)) {
                    return false;
                }
                libraryItems[countlibraryItems] = item;
                countlibraryItems++;
                
            }
        }
        
        return false;
    }
    
    @Override
    public boolean addMember(LibrarianAccount librarian, Account member) {
        
        if (this.librarian.equals(librarian)) {
            for (int i = 0; i < countImembers; i++) {
                if (members[i].equals(member)) {
                    return false;
                }
                members[countImembers] = (MemberAccount) member;
                countImembers++;
                
            }
        }
        
        return false;
        
    }
    
    @Override
    public ItemLending checkoutItem(MemberAccount member, Item borrowBook) {
        
        if (this.members.equals(member) && MAX_LENDING_BOOKS < countItemLending && borrowBook.equals("AVAILABLE")) {
            if (borrowBook.getBarcode() != null) {
                
            }
        }
        
        return null;
    }
    
    @Override
    public int checkForFine(MemberAccount member, ItemLending borrowItem) {
        if (this.members.equals(member)) {
            for (int i = 0; i < countItemLending; i++) {
                if (libraryLendingItems[i].equals(borrowItem)) {
                    libraryLendingItems[i].getFine(LocalDate.MIN);
                }
                
            }
            
        }
        return 0;
    }
    
    @Override
    public boolean returnItem(MemberAccount member, ItemLending returnItem) {
        if (this.members.equals(member)) {
            for (int i = 0; i < countItemLending; i++) {
                if (libraryLendingItems[i].equals(returnItem)) {
                    System.out.println(libraryLendingItems[i].getFine(LocalDate.MIN));
                }
                
            }
            
        }
        return true;
    }
    
    @Override
    public ItemLending[] getMyLendingList(MemberAccount member) {
        if (this.members.equals(member)) {
            for (int i = 0; i < countItemLending; i++) {
                System.out.println(libraryLendingItems[i]);;
                
            }
        }
        return null;
    }
    
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int index;

            @Override
            public boolean hasNext() {
                return index < countlibraryItems;
            }
            
            @Override
            public Item next() {
                
                if (hasNext() == false) {
                    System.out.println("No more Item");
                }
                return libraryItems[index++];
            }
        };
        
    }
    
}
