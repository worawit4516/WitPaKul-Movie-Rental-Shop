package wpk.serviceITF;

import wpk.Enum.AccountMovieStatus;
import wpk.Enum.MovieStatus;
import wpk.Enum.AccountStatus;
import wpk.Movie.Movie;
import wpk.Store.ManagerService;
import wpk.account.MemberAccount;

/**
 *
 * @author user
 */
public interface EmployeeService {

    public void SetService(ManagerService Service);

    public void SetEmployeesinStore(String EMPid ,String Password);
   
//ตรงนี้
    
    public boolean CreateMember(MemberAccount newmember);

    public boolean AddMovie(Movie newMovie);

    public boolean EditData_Member(String id, String MemberID, String firstname, String lastname, String password, long phone, AccountStatus status, AccountMovieStatus acstatus);

    public int SearchMovie(String movieTitle);

    public int SearchMember(String MemberID);

    public boolean DeleteMovie(String id, String movieID);

    public boolean DeleteMember(String id, String memberID);

    public int ListMembers();

    public int ListMovie();

    public int ListMovieborrow();

}
