import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MainDay1{
    
    public static void main(String[] args) throws FileNotFoundException {
        
        //open file
        FileReader fr = new FileReader("day1/1/data.txt");
        Scanner scan = new Scanner(fr);
        String line;

        int inventory = 0;
        int maxInventory = -1;

        //read lines
        while (scan.hasNextLine()) {

            //read first line
            line = scan.nextLine();

            if (inventory > maxInventory) {
                maxInventory = inventory;
            }

            inventory = 0;
            //One inventory
            while (line.length() > 0) {
                inventory += Integer.parseInt(line);
                if (scan.hasNextLine()) {
                    line = scan.nextLine();
                }else{
                    break;
                }
            }
        }

        //close file
        scan.close();

        System.out.println(maxInventory);

    }
}