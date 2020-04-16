/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpk.Store;

import wpk.Movie.Movie;
import wpk.Movie.MovieStatus;
import wpk.service.EmployeeAccount;
import wpk.service.MemberAccount;

/**
 *
 * @author user
 */
public class MemberService extends MovieStore {

    public MemberService(String storeName, int maxcustomer, int maxmember, int maxcdStoreMovie, int maxcdStoreBorrowingMovie, int maxemployees) {
        super(storeName, maxcustomer, maxmember, maxcdStoreMovie, maxcdStoreBorrowingMovie, maxemployees);
    }

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
    public boolean returnMovie(MemberAccount member, MovieBorrowmovie returnItem) {
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

    private int check(Object obj) {
        int countmember = 0;
        if (obj instanceof MemberAccount) {
            for (int i = 0; i < countmember; i++) {
                if (member[i].equals(obj)) {
                    return i;
                }
            }
        }
        return -1;

    }

    public int returnForFine(MemberAccount member, MovieBorrowmovie returnItem) {
        if (check(member) >= 0) {
            return member.checkForFine(returnItem);
        } else {
            return -1;
        }

    }

    public MovieBorrowing[] ShowMovieBorrowingList(MemberAccount member) {
        if (check(member) >= 0) {
            //member get??
            return member.();
        } else {
            return null;
        }
    }
}
