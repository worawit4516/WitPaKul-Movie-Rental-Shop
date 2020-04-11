package lib.service;

import lib.account.Account;
import lib.person.Person;

public class LibrarianAccount extends Account {
    public LibrarianAccount(String id, String password, Person person) {
        super(id, password, person);
    }

    public LibrarianAccount(Account account) {
        super(account);
    }
}
