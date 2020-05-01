package wpk.MenuMethod;
import static wpk.MainMenu.MainMenu.Sc;
import wpk.Enum.AccountStatus;
import wpk.account.EmployeeAccount;

/**
 *
 * @author Earty
 */
public class MM_Manager {

    //-------------------MenuManager--------------------------------
    public static EmployeeAccount CreateEmployeesAccount() {
        int count = 0;
        System.out.println("----Creat EmployeesAccount----");
        System.out.println("Firstname : ");
        Sc.nextLine();
        String firstname = Sc.nextLine();

        while (firstname.equals("")) {
            System.out.println("firstname must not null");
            System.out.println("Firstname : ");
            firstname = Sc.nextLine();
        }

        System.out.println("Lastname : ");
        String lastname = Sc.nextLine();
        while (lastname.equals("")) {
            System.out.println("Lastname must not null");
            System.out.println("Lastname : ");
            lastname = Sc.nextLine();
        }

        System.out.println("Password : ");
        String password = Sc.nextLine();
        while (lastname.equals("")) {
            System.out.println("Password must not null");
            System.out.println("Password : ");
            password = Sc.nextLine();
        }
        System.out.println("Phone : ");

        long phone = Sc.nextLong();
        AccountStatus status = AccountStatus.EMPLOYEE;

        if (firstname == null || lastname == null || password == null) {
            System.out.println("NULL are prohibited");
            CreateEmployeesAccount();
        }

        String id = String.format("EMP0%d", (count + 1));

        EmployeeAccount employee = new EmployeeAccount(id, firstname, lastname, password, phone, status);

        return employee;
    }

    public static EmployeeAccount EditdataEmployeesAccount() {

        System.out.println("----Edit EmployeesAccount----");
        System.out.println("ID :");
        String id = Sc.next();
        Sc.nextLine();

        System.out.println("Firstname : ");
        String firstname = Sc.nextLine();
        while (firstname.equals("")) {
            System.out.println("firstname must not null");
            System.out.println("Firstname : ");
            firstname = Sc.nextLine();
        }

        System.out.println("Lastname : ");
        String lastname = Sc.nextLine();
        while (lastname.equals("")) {
            System.out.println("Lastname must not null");
            System.out.println("Lastname : ");
            lastname = Sc.nextLine();
        }

        System.out.println("Password : ");
        String password = Sc.nextLine();
        while (lastname.equals("")) {
            System.out.println("Password must not null");
            System.out.println("Password : ");
            password = Sc.nextLine();
        }
        System.out.println("Phone : ");
        long phone = Sc.nextLong();

        AccountStatus status = AccountStatus.EMPLOYEE;

        if (id.equals("") || firstname.equals("") || lastname.equals("") || password.equals("")) {
            System.out.println("NULL are prohibited");
            EditdataEmployeesAccount();
        }

        EmployeeAccount employee = new EmployeeAccount(id, firstname, lastname, password, phone, status);

        return employee;
    }

    public static String InputEmployeesID() {

        System.out.println("----Employees ID----");
        System.out.println("ID : ");
        Sc.nextLine();
        String id = Sc.nextLine();
        while (id.equals("")) {
            System.out.println("Employees ID must not null");
            System.out.println("Employees ID : ");
            id = Sc.nextLine();
        }

        return id;

    }

    //-------------------MenuManager--------------------------------
}
