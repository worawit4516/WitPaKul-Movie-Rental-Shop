package lib.service;
import lib.item.Item;

public class Library  {
    private String libraryName;
    private MemberAccount members[];
    private LibrarianAccount librarian;
    private Item libraryItems[];
    private ItemLending libraryLendingItems[];
     
    public Library(String libraryName, LibrarianAccount librarian, int maxItem, int maxMember, int maxLendingItem) {
        this.libraryName = libraryName;
        this.libraryLendingItems = new ItemLending[maxLendingItem];
        this.members = new MemberAccount[maxMember];
        this.libraryItems = new Item[maxItem];
        this.librarian = librarian;
    }

   

}
