
package wpk_DataBase;
import wpk_DataBase.DBConnection;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import wpk_DataBase.model.Customer;
/**
 *
 * @author Earty
 */
public class Testdatabase {
    
    static Scanner sc;

    public static void main(String[] args) {
        
        createCustomerTable();
        testJDBCV2();
        selectdata();
    }

    public static void createCustomerTable() {

        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/WitPaKul_database","wpk","wpk");
                Statement stm = conn.createStatement()) {
            try {
                stm.executeUpdate("DROP TABLE customer");
            } catch (SQLException ex) {
            }
            try {
                stm.executeUpdate("CREATE TABLE customer (cust_id INT NOT NULL,cust_name VARCHAR(100),PRIMARY KEY(cust_id))");
            } catch (SQLException ex) {
            }
        } catch (SQLException ex) {
            
        }
    }
    
    
    
    

    public static void readCSV(String file) {
        try {
            sc = new Scanner(new File(file));
            String line;
            while (sc.hasNext()) {
                line = sc.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found: " + ex.getMessage());
        } finally {
            sc.close();
        }
    }

    
    public static void testJDBCV2() {
        
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/WitPaKul_database","wpk","wpk");
                Statement stm = conn.createStatement()) {
          
        stm.executeUpdate("INSERT INTO customer VALUES(1,'Worawit')");
        stm.executeUpdate("INSERT INTO customer VALUES(2,'Pawut')");
        stm.executeUpdate("INSERT INTO customer VALUES(3,'Sakultip')");
        
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public static void selectdata() {
        Customer[] customer = new Customer[10];
        int i =0;
         try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/WitPaKul_database","wpk","wpk");
                Statement stm = conn.createStatement()) {
         
        ResultSet cus_rs = stm.executeQuery("SELECT * FROM customer");
        while(cus_rs.next())
        {  customer[i++] = new Customer(cus_rs.getInt("cust_id"),cus_rs.getString("cust_name"));
        
        }
            
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        for (int j = 0; j < i; j++) {
            System.out.println(customer[j]);
        }
    }
}
