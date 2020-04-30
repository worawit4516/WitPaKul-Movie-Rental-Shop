/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpk.MainMenu;

import wpk.Store.MovieStore;
import wpk.Enum.AccountStatus;
import wpk.Store.ManagerService;
import wpk.account.ManagerAccount;
import wpk.Enum.AccountMovieStatus;
import wpk.Enum.MovieStatus;
import java.util.Scanner;
import wpk.MainMenu.MainMenu;
import wpk.account.ManagerAccount;
import wpk.account.Account;

/**
 *
 * @author user
 */
/*
public class Menu {

    private String id = "1";
    private String password = "1";
    private Scanner Sc;
    private int SeChoice;

    public Menu() {
        this.Sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        
        
        
    }
    
  public static void ChoiceManager() {
        System.out.println("---Store System---"); 
        System.out.println("1.Employees");
        System.out.println("");
        System.out.println("5.Exit...");
        System.out.println("-------------");
        System.out.println("Enter Your Menu [1‐5]: ");
        //SeChoice = Integer.parseInt(Sc.nextLine());

    }
    public static void ChoiceEmployees() {
        System.out.println("---Store System---"); 
        System.out.println("3.Member");
        System.out.println("4.Movie");
        System.out.println("5.Exit...");
        System.out.println("-------------");
        System.out.println("Enter Your Menu [1‐5]: ");
       // SeChoice = Integer.parseInt(Sc.nextLine());

    }
     
    public static void  ChoiceMenu() {
        System.out.println("---Store System---");
        System.out.println("1.Manager");
        System.out.println("2.Employee");    
        System.out.println("3.Exit...");
        System.out.println("-------------");
        System.out.println("Enter Your Menu [1‐3]: ");
       // SeChoice = Integer.parseInt(Sc.nextLine());

    }
    
     
     
     
    public void MenuMenager() {

        do {
            ChoiceManager();
            switch (SeChoice) {
                case 1:
                   

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
            }
        } while (SeChoice != 0);
        System.out.println("Out.....");
    }

    public int getSelectedChoice() {

        return SeChoice;
    }

    public void Exit(int exit) {
        Sc.close();
        System.out.println(exit);
    }

    public void Mnlogin() {
        while (Managerlogin() == false) {
            System.out.println("Wrong code.... Request to enter a new code correctly.");
        }
    }

    public static boolean Managerlogin() {
        System.out.println("----Login Manager----");
        System.out.println("Name :");
        String id = Sc.nextLine();
        System.out.println("Password :");
        String password = Sc.nextLine();

        return this.id.equals(id) && this.password.equals(password);
    }

}
*/