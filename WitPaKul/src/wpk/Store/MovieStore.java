package wpk.Store;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import wpk.Enum.AccountStatus;
import wpk.Enum.MovieStatus;
import wpk.account.MemberAccount;
import wpk.serviceITF.Specifications;
import wpk.Movie.Movie;
import wpk.Enum.AccountMovieStatus;
import wpk.Movie.MovieBorrowing;
import wpk.serviceITF.EmployeeService;
import wpk.serviceITF.MemberService;
import wpk.account.ManagerAccount;

public class MovieStore implements Specifications, EmployeeService, MemberService {

    private final String storeName;
    private ManagerAccount managerAccount;
    private MemberAccount member[];
    private Movie cdStoreMovie[];//เก็บจำนวนหนังในร้าน
    private MovieBorrowing cdStoreBorrowingMovie[]; //เก็บจำนวนหนังที่ถูกยืมในร้าน
    private ManagerService Service;
    private int countmember = 0, countMovie = 0, countMovieborrowing = 0;

    public MovieStore(String storeName, int maxmember, int maxcdStoreMovie, int maxcdStoreBorrowingMovie) {
        this.storeName = storeName;
        this.member = new MemberAccount[maxmember];
        this.cdStoreMovie = new Movie[maxcdStoreMovie];
        this.cdStoreBorrowingMovie = new MovieBorrowing[maxcdStoreBorrowingMovie];

    }

    @Override
    public void SetService(ManagerService Service) {
        try {
            this.Service = Service;
            this.managerAccount = this.Service.getManager();
            System.out.println("Complete");
        } catch (Exception e) {
            System.out.println("failed to set");
        }
    }


    @Override
    public boolean LoginEmployeesinStore(String EMPid, String password) {
        if (EMPid != null || password == null) {

            if (Service.getManager().getId().equals(EMPid) && Service.getManager().getPassword().equals(password)) {
                System.out.println("Login Complete");
                System.out.println("Welcome");
                return true;
            }
            if (Service.checkEmployeesByID(EMPid) == null) {
                System.out.println("failed to Login");
                return false;
            }
            return true;
        }
        if (Service.checkEmployeesByID(EMPid).getId().equals(EMPid) && password.equals(Service.checkEmployeesByID(EMPid).getPassword())) {
            System.out.println("Welcome");
            return true;
        }

        return false;

    }

    //Employeeservice code part//
    @Override
    public boolean CreateMember(MemberAccount newmember) {

        if (checkMember(newmember.getId()) == -1 && countmember < this.member.length) {
            this.member[countmember++] = newmember;
            System.out.println("successfully created");
            return true;
        } else {
            System.out.println("failed to create member");
            return false;
        }

    }

    @Override
    public boolean AddMovie(Movie newMovie) {

        if (checkMovie(newMovie.getMovield()) == -1 && countMovie < cdStoreMovie.length) {
            this.cdStoreMovie[countMovie++] = newMovie;
            System.out.println("successfully created");
            return true;

        } else {
            System.out.println("failed to create data");
        }

        return true;
    }

    @Override
    public boolean EditData_Member(MemberAccount MB) {

        String id = MB.getId();
        String firstname = MB.getFirstname();
        String lastname = MB.getLastname();
        String password = MB.getPassword();
        long phone = MB.getPhone();
        AccountStatus status = MB.getStatus();

        for (int i = 0; i < countmember; i++) {
            if (member[i].getId().equals(id)) {
                member[i].editDataMember(firstname, lastname, password, phone, status, AccountMovieStatus.ACTIVEB);
                System.out.println("Complete");
                return true;
            }
        }

        System.out.println("404 data not found");

        return false;

    }

    //Search Part
    @Override
    public int SearchMovie(String movieTitle) {
        if (movieTitle == null) {
            System.out.println("NULL are prohibited");

            return -1;
        }

        for (int i = 0; i < countMovie; i++) {
            if (movieTitle == null ? cdStoreMovie[i].getMovieTitle() == null : movieTitle.equals(cdStoreMovie[i].getMovieTitle())) {
                System.out.println(cdStoreMovie[i]);

            }
        }

        System.out.println("404 data not found");

        return -1;
    }

    @Override
    public int SearchMember(String MemberID) {
        if (MemberID == null) {
            System.out.println("NULL are prohibited");

            return -1;
        }

        for (int i = 0; i < countmember; i++) {
            if (MemberID == null ? member[i].getId() == null : MemberID.equals(member[i].getId())) {
                System.out.println(member[i]);
                return 1;
            }
        }

        System.out.println("404 data not found");

        return -1;
    }

    @Override
    public int SearchMovieBorrowinstore(String movieID) {
        if (movieID == null) {
            System.out.println("NULL are prohibited");

            return -1;
        }

        for (int i = 0; i < countMovieborrowing; i++) {
            if (movieID == null ? cdStoreBorrowingMovie[i].getMovieBorrow().getMovield() == null : movieID.equals(cdStoreBorrowingMovie[i].getMovieBorrow().getMovield())) {
                System.out.println(cdStoreBorrowingMovie[i]);

            }
        }

        System.out.println("404 data not found");

        return -1;
    }

    @Override
    public int checkprice(String MovieID) {
        
        if (checkMovieByID(MovieID) == null) {
            System.out.println("Data 404 not found");
            return -1;
        }
  
        try {
            System.out.println("This Movie Price is : " + checkMovieByID(MovieID).getPrice());
        } catch (Exception e) {

            System.out.println("Please enter only the MovieID");

        }

        return 1;
    }

    //Delete Part
    @Override
    public boolean DeleteMovie(String movieID) {
        if (movieID == null) {
            System.out.println("NULL are prohibited");

            return false;
        }
        if (checkMovie(movieID) != -1) {
            for (int i = 0; i < countMovie; i++) {
                if (checkMovie(movieID) == i) {

                    for (int j = i + 1; j < countMovie; j++) {
                        cdStoreMovie[i] = cdStoreMovie[j];
                    }
                    cdStoreMovie[--countMovie] = null;
                    System.out.println("Compleate");
                    return true;
                }
            }

        }
        System.out.println("404 data not found");
        return false;
    }

    @Override
    public boolean DeleteMember(String memberID) {

        if (memberID == null) {
            System.out.println("NULL are prohibited");

            return false;
        }
        if (checkMember(memberID) != -1) {
            for (int i = 0; i < countmember; i++) {
                if (checkMember(memberID) == i) {

                    for (int j = i + 1; j < countmember; j++) {
                        member[i] = member[j];
                    }
                    member[--countmember] = null;
                    System.out.println("Compleate");
                    return true;
                }
            }

        }
        System.out.println("404 data not found");
        return false;

    }

    private boolean DeleteBorrowMovie(String movieBorrowID) {
        if (movieBorrowID == null) {
            System.out.println("NULL are prohibited");

            return false;
        }

        for (int i = 0; i < countMovieborrowing; i++) {
            if (checkMovieBorrow(movieBorrowID) == i) {

                for (int j = i + 1; j < countMovieborrowing; j++) {
                    cdStoreBorrowingMovie[i] = cdStoreBorrowingMovie[j];
                }
                cdStoreBorrowingMovie[--countMovieborrowing] = null;

                return true;
            }
        }

        return false;
    }
    //-----------

//---------

    //MovieService Code part//
    private MovieBorrowing checkOutMovieinstore(String memberId, String movieID) {
        if (memberId == null || movieID == null) {
            System.out.println("NULL are prohibited");

            return null;
        }

        if (checkMemberByID(memberId).getAccountMovieStatus() != AccountMovieStatus.ACTIVEB) {
            System.out.println("Your account is inACTIVE");
            return null;
        }

        if (checkMovieByID(movieID).getMovieStatus() == MovieStatus.Borrowed) {
            System.out.println("cannot borrow now");
            return null;
        }

        if (checkMemberByID(memberId).getMemberStatus().equals(AccountStatus.MEMBER) && checkMovieByID(movieID).getPremiumStatus() == 1) {
            System.out.println("This movie is Premium");
            System.out.println("Please upgrade your account to borrow this movie");
            return null;

        }

        MovieBorrowing movieBorrowing = new MovieBorrowing();
        MovieBorrowing checkoutMOvie = movieBorrowing.checkOutMovie(checkMovieByID(movieID), checkMemberByID(memberId));
        cdStoreBorrowingMovie[countMovieborrowing++] = checkoutMOvie;
        System.out.println("Check out complete\n");

        //checkMemberByID(memberId).checkoutMovie(checkoutMOvie);
        return checkoutMOvie;
    }

    @Override
    public boolean CheckoutMovie(String memberId, String movieID) {
        if (memberId == null || movieID == null) {
            System.out.println("NULL are prohibited");
            return false;
        }
        if (checkMemberByID(memberId) == null || checkMovieByID(movieID) == null) {
            System.out.println("Your not Member or No Movie in this Store");
            return false;

        }
        checkMemberByID(memberId).checkoutMovie(checkOutMovieinstore(memberId, movieID));
        return true;
    }

    @Override
    public boolean returnMovie(String memberId, String movieborrowID) {
        if (memberId == null || movieborrowID == null) {
            System.out.println("NULL are prohibited");

            return false;
        }

        if (checkMemberByID(memberId) == null || checkMovieborrowByID(movieborrowID) == null) {
            System.out.println("Your not Member or No Movie in this Store");
            return false;

        }
        if (checkMemberByID(memberId).getId().equals(memberId) && checkMovieborrowByID(movieborrowID).getMovieBorrow().getMovield().equals(movieborrowID)) {

            int fine = checkMovieborrowByID(movieborrowID).returnMovie(checkMemberByID(memberId));
            checkMemberByID(memberId).returnMovie(checkMovieborrowByID(movieborrowID), fine);

            System.out.println("Return Complete");
            if (fine > 0) {
                System.out.println("Fine: " + fine);
            }
            DeleteBorrowMovie(movieborrowID);
            return true;
        }
        return false;

    }

    @Override
    public int CheckForFine(String memberId, String movieID) {

        if (memberId == null || movieID == null) {
            System.out.println("NULL are prohibited");

            return -1;
        }

        if (checkMember(memberId) >= 0) {
            System.out.println("\nYour Fine for this movie is : " + checkMemberByID(memberId).checkForFine(checkMovieborrowByID(movieID)));
            return checkMemberByID(memberId).checkForFine(checkMovieborrowByID(movieID));
        } else {
            System.out.println("No Member or Movie in Store");
            return -1;
        }

    }

    //List Part
    @Override
    public int ListMembers() {

        System.out.println("All members: " + countmember);

        for (int i = 0; i < countmember; i++) {

            System.out.println((i + 1) + " Members: " + member[i].toString());

        }
        return -1;
    }

    @Override
    public int ListMovie() {

        System.out.println("Movies in our store: " + countMovie);

        for (int i = 0; i < countMovie; i++) {

            System.out.println((i + 1) + " Movies: " + cdStoreMovie[i].toString());

        }
        return -1;
    }

    @Override
    public int ListMovieborrow() {

        System.out.println("All borrow movies in our store: " + countMovieborrowing);

        for (int i = 0; i < countMovieborrowing; i++) {

            System.out.println((i + 1) + ". " + cdStoreBorrowingMovie[i].getMovieBorrow().getMovield() + " " + cdStoreBorrowingMovie[i].getMovieBorrow().getMovieTitle());

        }
        return -1;
    }

    @Override
    public void ListMemberBorrowingList(String id) {
        if (checkMember(id) != -1) {
            checkMemberByID(id).getMovieBorrowList();

        }

    }

    //Check path
    private int checkMovie(String id) {
        if (id != null) {
            for (int i = 0; i < countMovie; i++) {
                if (cdStoreMovie[i].getMovield() == null ? id == null : cdStoreMovie[i].getMovield().equals(id)) {
                    return i;
                }
            }
        }
        return -1;

    }

    private int checkMovieBorrow(String id) {
        if (id != null) {
            for (int i = 0; i < countMovieborrowing; i++) {
                if (cdStoreBorrowingMovie[i].getMovieBorrow().getMovield() == null ? id == null : cdStoreBorrowingMovie[i].getMovieBorrow().getMovield().equals(id)) {
                    return i;
                }
            }
        }
        return -1;

    }

    private int checkMember(String id) {
        if (id != null) {
            for (int i = 0; i < countmember; i++) {
                if (member[i].getId() == null ? id == null : member[i].getId().equals(id)) {
                    return i;
                }
            }
        }
        return -1;

    }

    private Movie checkMovieByID(String MovieID) {
        if (MovieID != null) {
            for (int i = 0; i < countMovie; i++) {
                if (cdStoreMovie[i].getMovield() == null ? MovieID == null : cdStoreMovie[i].getMovield().equals(MovieID)) {
                    return cdStoreMovie[i];
                }
            }
        }
        return null;

    }

    private MemberAccount checkMemberByID(String MemberID) {
        if (MemberID != null) {
            for (int i = 0; i < countmember; i++) {
                if (member[i].getId() == null ? MemberID == null : member[i].getId().equals(MemberID)) {
                    return member[i];
                }
            }
        }

        return null;

    }

    private MovieBorrowing checkMovieborrowByID(String MovieborrowID) {
        if (MovieborrowID != null) {

            for (int i = 0; i < countMovieborrowing; i++) {

                if (cdStoreBorrowingMovie[i].getMovieBorrow().getMovield() == null ? MovieborrowID == null : cdStoreBorrowingMovie[i].getMovieBorrow().getMovield().equals(MovieborrowID)) {

                    return cdStoreBorrowingMovie[i];
                }

            }

        }
        return null;

    }

    //IO path
    @Override
    public void CreateReceipts(String Memberid) {
        if (checkMemberByID(Memberid) == null) {
            System.out.println("No this member in Store");
            return;
        }
        

        try (PrintWriter pw = new PrintWriter(new File("receipts.txt"))) {
            MovieBorrowing[] me = checkMemberByID(Memberid).ReturnIO();
            StringBuilder str = new StringBuilder();

            str.append("\n           *******HELLO******\n");
            if (me.equals(null)) {
                str.append("NO Movie");
            } else {
                for (int i = 0; i < me.length; i++) {
                    if (me[i] == null) {

                    }
                    if (me[i] != null) {

                        str.append((i + 1) + ". " + me[i].toString());

                    }

                }
            }
            str.append("           Total price: " + checkMemberByID(Memberid).getTotalprice());
            str.append("\n        ******THANK YOU******");
            System.out.println(str);
            pw.println(str);
        } catch (FileNotFoundException ex) {

        }
    }

    public void createNewReceipts(String text) {
        File file = new File("receipts.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            try (BufferedWriter bf = new BufferedWriter(new FileWriter(file, false))) {
                // bf.append(checkMemberByID(text).ReturnIO());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
