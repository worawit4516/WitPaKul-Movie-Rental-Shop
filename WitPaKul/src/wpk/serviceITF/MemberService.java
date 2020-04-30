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

    public boolean CheckoutMovie(String memberId, String movieID);

    public boolean returnMovie(String memberId, String movieborrowID);

}
