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
public interface MemberService {

    public MovieBorrowing checkOutMovie(MemberAccount member, Movie borrowMovie);

    public boolean returnMovie(MemberAccount member, MovieBorrowing returnItem);

    public int check(Object obj);

    public int returnForFine(MemberAccount member, MovieBorrowing returnItem);

    public MovieBorrowing[] ShowMovieBorrowingList(MemberAccount member);
}
