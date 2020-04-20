/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpk.service;

import wpk.Movie.Movie;
import Enum.MovieStatus;
import wpk.Store.MovieBorrowing;
import wpk.account.EmployeeAccount;
import wpk.account.MemberAccount;

/**
 *
 * @author user
 */
public interface MemberService {

    public MovieBorrowing checkOutMovie(MemberAccount member, Movie borrowMovie);

    public boolean returnMovie(MemberAccount member, MovieBorrowing returnItem);

    public int check(Object obj);

    public int returnForFine(MemberAccount member, MovieBorrowing returnItem);

    public MovieBorrowing[] ShowMovieBorrowingList(MemberAccount member);
}
