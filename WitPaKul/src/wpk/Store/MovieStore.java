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
import wpk.Store.MemberService;
import wpk.Store.Specifications;

/**
 *
 * @author user
 */
public class MovieStore implements Specifications,EmployeeService{

    private String storeName;
    MemberAccount member[];
    private Movie cdStoreMovie[];
    private MovieBorrowing cdStoreBorrowingMovie[];
    EmployeeAccount employee;
    private int countmember = 0, countMovie = 0, countEmployee = 0;
    private EmployeeAccount employees[];
   

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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Employeeservice code part//
    
  
   

    
    public boolean addMember(EmployeeAccount employee, MemberAccount member) {
        if (employee.equals(this.employee)) {
            MemberAccount newmeber = new MemberAccount(member);
            if (check(member) == -1 && countmember < this.member.length) {
                this.member[countmember++] = newmeber;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean addMovie(EmployeeAccount employee, Movie newmovie) {
        if (employee.equals(this.employee)) {
            if (check(newmovie) == -1 && countMovie < cdStoreMovie.length) {
                this.cdStoreMovie[countMovie++] = newmovie;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean EditData_Member(EmployeeAccount employee, MemberAccount member) {
      return true;
    }

    public int SearchMovie(String movieTitle) {
      return 1; 
    }

    public int SearchMember(int MemberID) {
      return 1;
    }

    public boolean DeleteMovie(EmployeeAccount employee, Movie deleteMovie, Object obj) {
        if (obj instanceof Movie) {
            for (int i = check(obj); i < countMovie; i++) {
                if (i == countMovie - 1) {
                    cdStoreBorrowingMovie[i] = null;
                } else {
                    cdStoreBorrowingMovie[i] = cdStoreBorrowingMovie[i + 1];
                }
            }
            countMovie--;

        }
        return false;
    }

    public boolean DeleteMember(EmployeeAccount employee, MemberAccount member, Object obj) {
        if (obj instanceof MemberAccount) {
            for (int i = check(obj); i < countmember; i++) {
                if (i == countmember - 1) {
                   this.member[i] = null;
                } else {
                    this.member[i] = this.member[i + 1];
                }
            }
            countmember--;

        }
        return false;
    }

    public boolean SetEmployee(EmployeeAccount employee) {

    }

    public int check(Object obj) {

        if (obj instanceof MemberAccount) {
            for (int i = 0; i < countmember; i++) {
                if (member[i].equals(obj)) {
                    return i;
                }
            }
            return -1;
        } else if (obj instanceof EmployeeAccount) {
            for (int i = 0; i < countEmployee; i++) {
                if (employees[i].equals(obj)) {
                    return i;
                }
            }
            return -1;
        } else if (obj instanceof MovieBorrowing) {
            for (int i = 0; i < countMovie; i++) {
                if (cdStoreBorrowingMovie[i].equals(obj)) {
                    return i;
                }
            }
            return -1;
        } else {
            return -2;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    //MovieService Code part//
    
      public MovieBorrowing checkOutMovie(MemberAccount member, Movie borrowMovie) {
        if (check(member) >= 0) {
            if (member.getTotalMoviecheckedOut() < Specifications.MAX_BORROWDAYS && borrowMovie.getMovieStaus() == MovieStatus.Available) {
                if (borrowMovie instanceof Movie) {
                    Movie movie = (Movie) borrowMovie;

                    MemberAccount checkedMovie = new MemberAccount();
                    checkedMovie.checkOutMovie(movie, member);
                    cdStoreBorrowingMovie[count++] = checkedMovie;
                    return checkedMovie;
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

    /*checkoutItem(Item borrowItem, MemberAccount lendingMember) {
        this.borrowDate = LocalDate.of(2020, Month.FEBRUARY, 20);
        //this.borrowDate = LocalDate.now;
        this.dueDate = borrowDate.plus(Policy.MAX_LENDING_DAYS, ChronoUnit.DAYS);
        this.lendingItem = borrowItem;
        this.lendingMember = lendingMember;
        this.lendingItem.setItemStatus(ItemStatus.BORROWED);
        return this; 
    
    }*/
    public boolean returnMovie(MemberAccount member, MovieBorrowing returnItem) {
        if (check(member) >= 0) {
            //no getlending ??
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

 
    public int returnForFine(MemberAccount member, MovieBorrowing returnItem) {
        if (check(member) >= 0) {
            return member.checkForFine(returnItem);
        } else {
            return -1;
        }

    }

    public MovieBorrowing[] ShowMovieBorrowingList(MemberAccount member) {
        if (check(member) >= 0) {
            //member get??
            return ShowMovieBorrowingList(member);
        } else {
            return null;
        }
    }
}
