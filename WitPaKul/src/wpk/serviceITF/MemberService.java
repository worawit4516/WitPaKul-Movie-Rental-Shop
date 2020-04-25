/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpk.serviceITF;

import wpk.Movie.Movie;
import wpk.Movie.MovieBorrowing;
import wpk.account.MemberAccount;

/**
 *
 * @author user
 */
public interface MemberService {

    public void ListMemberBorrowingList(String id);

    public int CheckForFine(String memberId, String movieID);

    public boolean CheckoutMovieMember(String memberId, String movieID);

    public boolean returnMovie(String memberId, String movieborrowID);

}
