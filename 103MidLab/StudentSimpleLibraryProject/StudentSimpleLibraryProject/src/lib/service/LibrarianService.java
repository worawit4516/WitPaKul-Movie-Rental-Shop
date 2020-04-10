package lib.service;
import lib.account.Account;
import lib.item.Item;

interface LibrarianService {
    public abstract boolean addItem(LibrarianAccount librarian, Item item);
    public abstract boolean addMember(LibrarianAccount librarian, Account member);
}
