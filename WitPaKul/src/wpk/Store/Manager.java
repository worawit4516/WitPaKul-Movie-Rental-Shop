/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpk.Store;

import wpk.service.EmployeeAccount;
import wpk.account.Account;
import wpk.account.AccountStatus;
import wpk.service.EmployeeAccount;
import wpk.Store.MovieStore;

/**
 *
 * @author user
 */
public class Manager {

    private EmployeeAccount employee[];
    private int countManager = 0, countMovie = 0, countEmployee = 0;

    public Manager(int maxemployee) {

        this.employee = new EmployeeAccount[maxemployee];
    }

    public boolean EditData_Employees(EmployeeAccount manager, EmployeeAccount employee) {
        return false;

    }

    public int SearchEmployees(EmployeeAccount manager, EmployeeAccount employee) {
        if (employee == null) {
            return -1;
        }
        for (int i = 0; i < count; i++) {

        }

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
                    employee[i] = null;
                } else {
                    employee[i] = employee[i + 1];
                }

            }
            countEmployee--;
        }
        return false;
    }

    public boolean AddEmpolyees(EmployeeAccount manager, EmployeeAccount employee) {
        if (manager.equals(this.employee)) {
            if (check(countEmployee) == -1 && countEmployee < employee.length) {
                this.employee[countEmployee++] = employee;
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
                if (employee[i].equals(obj)) {
                    return i;
                }
            }
        }
        return -1;

    }

}
