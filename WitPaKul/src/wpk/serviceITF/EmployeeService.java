package wpk.serviceITF;

import wpk.Movie.Movie;
import wpk.Store.ManagerService;
import wpk.account.MemberAccount;

/**
 *
 * @author user
 */
public interface EmployeeService {

    public void SetService(ManagerService Service);

    public boolean LoginEmployeesinStore(String EMPid,String password);
   
//ตรงนี้
    
    public boolean CreateMember(MemberAccount newmember);//

    public boolean AddMovie(Movie newMovie);//

    public boolean EditData_Member(MemberAccount MB);//

    public int SearchMovie(String movieTitle);

    public int SearchMember(String MemberID);
   
    //public boolean CheckMoviePrice(String movieID);
    
    public int SearchMovieBorrowinstore(String movieID); 

    public boolean DeleteMovie( String movieID);

    public boolean DeleteMember( String memberID);

    public int ListMembers();

    public int ListMovie();

    public int ListMovieborrow();
    
    public void CreateReceipts(String Memberid);
    
  
}
