package Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import wpk.Store.MovieStore;

/**
 *
 * @author Sathipp
 */
public class Receipts {

    public static MovieStore movieja;
    public static String memberID;

    public Receipts(MovieStore MovieStore) {
        
        this.movieja = MovieStore;
       
    }
    
    public void SetMemberID(String ID)
    { this.memberID = ID;
    }

    public void CreateReceipts() {
        
            try (PrintWriter pw = new PrintWriter(new File("receipts.txt"))) {
                pw.println(movieja.checkMemberByID(memberID).ReturnIO());
            } catch (FileNotFoundException ex) {
            }
        }
        //        try {
        //            File filename = new File("receipts.txt");
        //            FileWriter fw = new FileWriter(filename);
        //            BufferedWriter bw = new BufferedWriter(fw);
        //            bw.write("");
        //            bw.newLine();
        //            bw.close();
        //        }
        //        catch(IOException e){
        //            e.printStackTrace();
        //        }


    public void createNewReceipts(String text) {
        File file = new File("receipts.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            try (BufferedWriter bf = new BufferedWriter(new FileWriter(file, false))) {
                bf.append(movieja.checkMemberByID(memberID).ReturnIO());
               
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
