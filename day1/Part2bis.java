package day1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

//Doesn't work
public class Part2bis{
    
    public static void main(String[] args) throws FileNotFoundException {
        
        //open file
        FileReader fr = new FileReader("day1/2/data.txt");
        Scanner scan = new Scanner(fr);
        String line;

        int inventory = 0;
        int[] top3 = {0,0,0};

        
        while (scan.hasNextLine()) {

            //read first line
            line = scan.nextLine();

            if (inventory > top3[0]) {
                top3[0] = inventory;
            }else if (inventory > top3[1]) {
                top3[1] = inventory;
            }else if (inventory > top3[2]) {
                top3[2] = inventory;
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

        System.out.println(top3[0] + top3[1] + top3[2]);
    }
}