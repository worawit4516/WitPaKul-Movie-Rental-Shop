package wpk.serviceITF;


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
