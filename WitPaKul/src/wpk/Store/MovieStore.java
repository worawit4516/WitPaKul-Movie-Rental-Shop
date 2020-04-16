/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpk.Store;

import java.util.Iterator;
import wpk.account.Account;
import wpk.account.AccountStatus;
import wpk.person.Person;
import wpk.Movie.Movie;
import wpk.Movie.MovieStatus;
import wpk.service.MemberAccount;
import wpk.service.EmployeeAccount;

/**
 *
 * @author user
 */
public class MovieStore {

    private String storeName;
    MemberAccount member[];
    private Movie cdStoreMovie[];
    private MovieBorrowing cdStoreBorrowingMovie[];
    EmployeeAccount employee;
    private int countCustomer = 0, countMovie = 0, countEmployee = 0;

    public MovieStore(String storeName, int maxcustomer, int maxmember, int maxcdStoreMovie, int maxcdStoreBorrowingMovie, int maxemployees) {
        this.storeName = storeName;
        this.member = new MemberAccount[maxmember];
        this.cdStoreMovie = new Movie[maxcdStoreMovie];
        this.cdStoreBorrowingMovie = new MovieBorrowing[maxcdStoreBorrowingMovie];
        this.employee = employee;
        
    }
    public Iterator<Movie> iterator(){
         return new Iterator<Movie>() {
            private int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < cdStoreMovie.length;
            }

            @Override
            public Movie next() {
                return cdStoreMovie[counter++];
            }
        };
    }
}
