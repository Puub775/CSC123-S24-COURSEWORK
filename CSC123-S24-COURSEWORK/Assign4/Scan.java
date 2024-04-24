//Name: Pablo Conde 
//Email: pconde1@csudh.edu

import java.io.File;
import java.io.IOException;

/**
 * Scan class contains a main method to test the MyScanner class.
 * It demonstrates the usage of the MyScanner class.
 */

public class Scan {
	
	/**
     * Main method for testing purposes.
     * @param args Command-line arguments (not used in this method).
     */
	
    public static void main(String[] args) {
        MyScanner scan = new MyScanner("123 3.14 3.1 true Hello World");
        System.out.println(scan.nextInt());
        System.out.println(scan.nextDouble());        
        System.out.println(scan.nextFloat());
        System.out.println(scan.nextBoolean());
        System.out.println(scan.next());
        System.out.println(scan.nextLine());
        
        try {
            
            File myFile = new File("/Users/puub/mygit/testing.txt");

            
            MyScanner fileScan = new MyScanner(myFile);

          
            while (fileScan.hasNext()) {
                System.out.println(fileScan.next());
            }
        } catch (IOException e) {
           
            e.printStackTrace();
        }
    }
}
