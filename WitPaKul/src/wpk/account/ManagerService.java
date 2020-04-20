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
    private int maxemployee;
    public int countEmployee = 0;

    public ManagerService(int maxemployees, Manager manager) {
        this.employees = new EmployeeAccount[maxemployees];
        this.manager = manager;

    }

    public boolean EditData_Employees(Manager manager, EmployeeAccount employee, String id, String fristname, String lastname, String password, long phone, AccountStatus status) {
        if (manager.equals(this.manager) && check(employee) != -1) {
            for (int i = 0; i < countEmployee; i++) {
                if (employees[i] == employee) {
                    employees[i].editdata(id, fristname, lastname, password, phone, status);
                    System.out.println("Compleate");
                }
            }

        } else {
            System.out.println("Can't fine this Employee");
        }
        return true;

    }

    public int SearchEmployees(Manager manager, EmployeeAccount employee) {

        if (employee == null) {
            return -1;
        }
        if (manager.equals(this.manager) && check(employee) != -1) {
            for (int i = 0; i < countEmployee; i++) {
                if (employee == employees[i]) {
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
        for (int i = 0; i < countEmployee; i++) {
            System.out.println(employees[i].toString());
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

                return true;
            } else {
                return false;
            }
        }

        return false;

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
