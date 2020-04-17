/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpk.Store;

import wpk.account.EmployeeAccount;
import wpk.account.Account;
import wpk.account.AccountStatus;
import wpk.account.EmployeeAccount;
import wpk.Store.MovieStore;

/**
 *
 * @author user
 */
public class Manager {

    private EmployeeAccount employees[];
    private int countEmployee = 0;

    public Manager(int maxemployee) {

        this.employees = new EmployeeAccount[maxemployee];
    }

    public boolean EditData_Employees(EmployeeAccount manager, EmployeeAccount employee) {
        return false;

    }

    public int SearchEmployees(EmployeeAccount manager, EmployeeAccount employee) {
        if (employee == null) {
            return -1;
        }
        for (int i = 0; i < this.employees.length; i++) {

        }
        return -1;
    }
//NO

    public EmployeeAccount[] ListEmployees(EmployeeAccount manager) {
        return this.ListEmployees(manager);

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

    public boolean AddEmpolyees(EmployeeAccount manager, EmployeeAccount employee) {
        if (manager.equals(this.employees)) {
            if (check(countEmployee) == -1 && countEmployee < this.employees.length) {
                this.employees[countEmployee++] = employee;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private int check(Object obj) {
        if (obj instanceof EmployeeAccount) {
            for (int i = 0; i < countEmployee; i++) {
                if (employees[i].equals(obj)) {
                    return i;
                }
            }
        }
        return -1;

    }

}
