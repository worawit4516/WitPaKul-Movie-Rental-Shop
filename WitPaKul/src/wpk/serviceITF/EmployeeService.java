/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpk.serviceITF;

import wpk.Enum.AccountMovieStatus;
import wpk.Enum.MovieStatus;
import wpk.Enum.AccountStatus;
import wpk.Store.ManagerService;

/**
 *
 * @author user
 */
public interface EmployeeService {

    public void SetResouse(ManagerService resouse);

    public void SetEmployeesinStore(String EMPid);

    public boolean CreateMember(String Id, String fristname, String lastname, String password, long phone, AccountStatus status, AccountMovieStatus acstatus);

    public boolean AddMovie(String id, String movieTitle, int premiumStatus, MovieStatus mos);

    public boolean EditData_Member(String id, String MemberID, String fristname, String lastname, String password, long phone, AccountStatus status, AccountMovieStatus acstatus);

    public int SearchMovie(String movieTitle);

    public int SearchMember(String MemberID);

    public boolean DeleteMovie(String id, String movieID);

    public boolean DeleteMember(String id, String memberID);

    public void CheckoutMovieMember(String memberId, String movieID);

    public boolean returnMovie(String memberId, String movieborrowID);

    public int CheckForFine(String memberId, String movieID);

    public int ListMembers();

    public int ListMovie();

    public int ListMovieborrow();

    public void ListMemberBorrowingList(String id);
}
