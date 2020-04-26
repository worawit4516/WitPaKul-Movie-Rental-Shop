package wpk.Store;
import wpk.Enum.AccountStatus;
import wpk.account.EmployeeAccount;
import wpk.account.ManagerAccount;

/**
 *
 * @author user
 */
public class ManagerService {

    public EmployeeAccount[] employees;
    private ManagerAccount manager;
    private int countEmployee = 0;

    public ManagerService(int maxemployees, ManagerAccount manager) {
        this.employees = new EmployeeAccount[maxemployees];
        this.manager = manager;

    }

    public boolean ManagerServiceLogin(String ManagerID, String Password) {
        if (manager.getId().equals(ManagerID) && manager.getPassword().equals(Password)) {
            System.out.println("Login Compleate");

            return true;
        }
        System.out.println("Can't Login !!");
        return false;
    }

    public boolean CreatEmployeesAccount(String managerID, String fristname, String lastname, String password, long phone, AccountStatus status) {

        if (manager.getId().equals(managerID)) {
            String id = String.format("EMP0%d", countEmployee + 1);

            EmployeeAccount employee = new EmployeeAccount(id, fristname, lastname, password, phone, status);

            if (check(id) == -1 && countEmployee < this.employees.length && employee.getStatus() == AccountStatus.EMPLOYEE) {
                this.employees[countEmployee++] = employee;
                System.out.println("Compleate to Createdata this Employee");
                return true;
            }
        } else {
            System.out.println("Can't Createdata this Employee");
        }
        return true;

    }

    public boolean EditData_Manager(String managerID, String id, String fristname, String lastname, String password, long phone, AccountStatus status) {
        if (manager.getId().equals(managerID)) {
            this.manager.editmanager(id, fristname, lastname, password, phone, status);

            System.out.println("Compleate");
        } else {
            System.out.println("Can't fine this Manager");
        }
        return true;

    }

    public boolean EditData_Employees(String managerID, String id, String fristname, String lastname, String password, long phone, AccountStatus status) {
        if (manager.getId().equals(managerID)&& check(id) != -1) {
            for (int i = 0; i < countEmployee; i++) {
                if (employees[i].getId() == null ? id == null : employees[i].getId().equals(id)) {
                    employees[i].editdata(fristname, lastname, password, phone, status);
                    System.out.println("Compleate");
                }
            }

        } else {
            System.out.println("Can't fine this Employee");
        }
        return true;

    }

    public int SearchEmployees(String managerID, String id) {

        if (id == null) {
            return -1;
        }
        if (manager.getId().equals(managerID) && check(id) != -1) {
            for (int i = 0; i < countEmployee; i++) {
                if (id == null ? employees[i].getId() == null : id.equals(employees[i].getId())) {
                    System.out.println("Found! Data this Employee");
                    System.out.println(employees[i]);
                }
            }
        } else {
            System.out.println("Not found!");
        }

        return -1;
    }

    public int ListEmployees() {

        System.out.println("All Employees is " + countEmployee);
        System.out.println("Manager is " + manager.toString());
        for (int i = 0; i < countEmployee; i++) {

            System.out.println(". Employees is " + employees[i].toString());

        }
        return -1;
    }

    public boolean DeleteEmployees(String managerID, String id) {
        if (manager.getId().equals(managerID) && check(id) != -1) {
            for (int i = check(id); i < countEmployee; i++) {
                // EmployeeAccount employeeAccount = employee[i];
                if (i == countEmployee - 1) {
                    employees[i] = null;
                    System.out.println("Compleate to Delete data this Employee");

                } else {
                    employees[i] = employees[i + 1];
                }

            }
            countEmployee--;
        }
         System.out.println("Not found!");
        return false;
    }

    private int check(String id) {
        if (id != null) {
            for (int i = 0; i < countEmployee; i++) {
                if (employees[i].getId() == null ? id == null : employees[i].getId().equals(id)) {
                    return i;
                }
            }
        }
        return -1;

    }

    public EmployeeAccount checkEmployeesByID(String id) {

        if (id != null) {
            for (int i = 0; i < countEmployee; i++) {
                if (employees[i].getId() == null ? id == null : employees[i].getId().equals(id)) {
                   
                    return employees[i];

                }
            }
        }
        System.out.println("Not found!");

        return checkEmployeesByID(id);

    }

    public String checkmanager() {
        return manager.toString();
    }
}
