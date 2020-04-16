/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpk.Store;

import wpk.Movie.Movie;
import wpk.service.EmployeeAccount;
import wpk.service.MemberAccount;
import wpk.Store.MovieStore;

/**
 *
 * @author user
 */
public class EmployeeService extends MovieStore {

    private EmployeeAccount employee[];
    MovieBorrowing cdStoreBorrowingMovie[];
    MemberAccount member[];

    private int countmember = 0, countMovie = 0, countEmployee = 0;

    public EmployeeService(String storeName, int maxcustomer, int maxmember, int maxcdStoreMovie, int maxcdStoreBorrowingMovie, int maxemployees) {
        super(storeName, maxcustomer, maxmember, maxcdStoreMovie, maxcdStoreBorrowingMovie, maxemployees);

    }

    public boolean addMember(EmployeeAccount employee, MemberAccount member) {
        if (employee.equals(this.employee)) {
            MemberAccount newmeber = new MemberAccount(member);
            if (check(member) == -1 && countmember < member.length) {
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

    }

    public int SearchMovie(String movieTitle) {

    }

    public int SearchMember(int MemberID) {

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
                    member[i] = null;
                } else {
                    member[i] = member[i + 1];
                }
            }
            countmember--;

        }
        return false;
    }

    public boolean SetEmployee(EmployeeAccount employee) {

    }

    private int check(Object obj) {

        if (obj instanceof MemberAccount) {
            for (int i = 0; i < countmember; i++) {
                if (member[i].equals(obj)) {
                    return i;
                }
            }
            return -1;
        } else if (obj instanceof EmployeeAccount) {
            for (int i = 0; i < countEmployee; i++) {
                if (employee[i].equals(obj)) {
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
}
