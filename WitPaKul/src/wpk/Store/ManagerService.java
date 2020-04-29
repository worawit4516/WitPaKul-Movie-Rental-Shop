package wpk.Store;

import wpk.Enum.AccountStatus;
import wpk.account.EmployeeAccount;
import wpk.account.ManagerAccount;

/**
 *
 * @author user
 */
public class ManagerService {

    private EmployeeAccount[] employees;
    private ManagerAccount manager;
    private int countEmployee = 0;

    public ManagerService(int maxemployees, ManagerAccount manager) {
        this.employees = new EmployeeAccount[maxemployees];
        this.manager = manager;

    }

    public boolean ManagerServiceLogin(String ManagerID, String Password) {
        if (manager.getId().equals(ManagerID) && manager.getPassword().equals(Password)) {
            System.out.println("Login Complete");

            return true;
        }
        System.out.println("failed to login");
        return false;
    }

    public boolean CreateEmployeesAccount(EmployeeAccount newEMP) {

        if (check(newEMP.getId()) == -1 && countEmployee < this.employees.length && newEMP.getStatus() == AccountStatus.EMPLOYEE) {
            this.employees[countEmployee++] = newEMP;
            System.out.println("succeed");
            return true;
        } else {
            System.out.println("failed to create data");
        }

        return true;

    }

    public boolean EditData_Manager(String managerID, String id, String firstname, String lastname, String password, long phone, AccountStatus status) {
        if (manager.getId().equals(managerID)) {

            this.manager.editmanager(id, firstname, lastname, password, phone, status);

            System.out.println("Complete");
        } else {
            System.out.println("404 data not found");
        }
        return true;

    }

    public boolean EditData_Employees(EmployeeAccount EMP) {

        String id = EMP.getId();
        String firstname = EMP.getFirstname();
        String lastname = EMP.getLastname();
        String password = EMP.getPassword();
        long phone = EMP.getPhone();
        AccountStatus status = EMP.getStatus();

        for (int i = 0; i < countEmployee; i++) {
            
            if (employees[i].getId().equals(id)) {
                employees[i].editdata(firstname, lastname, password, phone, status);
                System.out.println("Complete");
                return true;
            }

        }

        System.out.println("404 data not found");

        return true;

    }

    public int SearchEmployees(String id) {

        if (id != null) {
            for (int i = 0; i < countEmployee; i++) {
                if (id == null ? employees[i].getId() == null : id.equals(employees[i].getId())) {
                    System.out.println(employees[i]);
                }

            }

        } else {
            System.out.println("404 data not found");
        }

        return -1;
    }

    public int ListEmployees() {

        System.out.println("Number of Employees: " + countEmployee);
        System.out.println("Manager: " + manager.toString());
        for (int i = 0; i < countEmployee; i++) {

            System.out.println(". Employees: " + employees[i].toString());

        }
        return -1;
    }

    public boolean DeleteEmployees(String managerID, String id) {
        if (manager.getId().equals(managerID) && check(id) != -1) {
            for (int i = check(id); i < countEmployee; i++) {
                // EmployeeAccount employeeAccount = employee[i];
                if (i == countEmployee - 1) {
                    employees[i] = null;
                    System.out.println("succeed");

                } else {
                    employees[i] = employees[i + 1];
                }

            }
            countEmployee--;
        }
        System.out.println("404 data not found");
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
        System.out.println("404 data not found");

        return checkEmployeesByID(id);

    }

    public String checkmanager() {
        return manager.toString();
    }
}
