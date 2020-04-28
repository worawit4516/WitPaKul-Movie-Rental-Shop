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

    public void SetService(ManagerService Service);

    public void SetEmployeesinStore(String EMPid ,String Password);

    public boolean CreateMember(String Id, String firstname, String lastname, String password, long phone, AccountStatus status, AccountMovieStatus acstatus);

    public boolean AddMovie(String id, String movieTitle,int premiumStatus, MovieStatus mos);

    public boolean EditData_Member(String id, String MemberID, String firstname, String lastname, String password, long phone, AccountStatus status, AccountMovieStatus acstatus);

    public int SearchMovie(String movieTitle);

    public int SearchMember(String MemberID);

    public boolean DeleteMovie(String id, String movieID);

    public boolean DeleteMember(String id, String memberID);

    public int ListMembers();

    public int ListMovie();

    public int ListMovieborrow();

}
