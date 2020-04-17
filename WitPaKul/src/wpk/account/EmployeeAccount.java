package wpk.account;

import wpk.account.Account;

public class EmployeeAccount {

    private Account account;

    public EmployeeAccount(Account account) {
        if (checkstatus(account)) {
            this.account = account;
            System.out.println("Setaccount Complate");
        } else {
            System.out.println("Can't Set this account");
        }

    }

    public boolean checkstatus(Account account) {
        if (account.getStatus().equals(AccountStatus.EMPLOYEE)) {
            return true;
        }
        return false;
    }

}
