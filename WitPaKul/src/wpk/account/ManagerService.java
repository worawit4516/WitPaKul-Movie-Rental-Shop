/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpk.account;

import wpk.account.EmployeeAccount;
import wpk.account.Account;
import wpk.account.AccountStatus;
import wpk.account.EmployeeAccount;
import wpk.Store.MovieStore;

/**
 *
 * @author user
 */
public class ManagerService {

    private EmployeeAccount employees[];
    private Manager manager;
    private int maxemployee ;
    public int countEmployee ;

    public ManagerService(int maxemployees) {
        this.maxemployee = maxemployees;

    }

    public boolean EditData_Employees(EmployeeAccount manager, EmployeeAccount employee) {
        return false;

    }

    public int SearchEmployees(Manager manager, EmployeeAccount employee) {

        if (employee == null) {
            return -1;
        }
        if (manager.equals(this.manager)) {
            check(employee);
        }
//        for (int i = 0; i < this.employees.length; i++) {
//               
//        }
        return -1;
    }
//NO

    public int ListEmployees() {
        for (int i = 0; i < countEmployee; i++) {
            System.out.println(employees[i]);
        }
        return -1;
    }

    public boolean DeleteEmployees(Object obj) {
        if (obj instanceof EmployeeAccount) {
            for (int i = check(obj); i < countEmployee; i++) {
                // EmployeeAccount employeeAccount = employee[i];
                if (i == countEmployee - 1) {
                    employees[i] = null;
                } else {
                    employees[i] = employees[i + 1];
                }

            }
            countEmployee--;
        }
        return false;
    }

    public boolean AddEmpolyees(Manager manager, EmployeeAccount employee) {

        if (manager.equals(this.manager)) {
            if (check(employee) == -1 && countEmployee < this.employees.length) {
                this.employees[countEmployee++] = employee;
                countEmployee++;
                return true;
            } else {
                return false;
            }
        }

        return true;

    }

    private int check(Object obj) {
        if (obj instanceof EmployeeAccount && obj != null) {
            for (int i = 0; i < countEmployee; i++) {
                if (employees[i].equals(obj)) {
                    return i;
                }
            }
        }
        return -1;

    }

}
