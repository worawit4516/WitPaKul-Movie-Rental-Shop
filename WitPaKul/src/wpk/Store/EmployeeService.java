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
public interface EmployeeService {

    public boolean addMember(EmployeeAccount employee, MemberAccount member);

    public boolean addMovie(EmployeeAccount employee, Movie newmovie);

    public boolean EditData_Member(EmployeeAccount employee, MemberAccount member);

    public int SearchMovie(String movieTitle);

    public int SearchMember(int MemberID);

    public boolean DeleteMovie(EmployeeAccount employee, Movie deleteMovie, Object obj);

    public boolean DeleteMember(EmployeeAccount employee, MemberAccount member, Object obj);

    public boolean SetEmployee(EmployeeAccount employee);

    public int check(Object obj);
}
