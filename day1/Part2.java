package day1;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Part2{
    
    public static void main(String[] args) throws FileNotFoundException {
        
        //open file
        FileReader fr1 = new FileReader("day1/data.txt");
        Scanner scan1 = new Scanner(fr1);
        String line;

        int inventory = 0;
        int top1 = 0;
        int top2 = 0;
        int top3 = 0;
        

        
        while (scan1.hasNextLine()) {

            //read first line
            line = scan1.nextLine();

            if (inventory > top1) {
                top1 = inventory;
            }

            inventory = 0;
            //One inventory
            while (line.length() > 0) {
                inventory += Integer.parseInt(line);
                if (scan1.hasNextLine()) {
                    line = scan1.nextLine();
                }else{
                    break;
                }
            }
        }
        //close file
        scan1.close();

        FileReader fr2 = new FileReader("day1/2/data.txt");
        Scanner scan2 = new Scanner(fr2);


        while (scan2.hasNextLine()) {

            //read first line
            line = scan2.nextLine();

            if (inventory > top2 && inventory != top1) {
                top2 = inventory;
            }

            inventory = 0;
            //One inventory
            while (line.length() > 0) {
                inventory += Integer.parseInt(line);
                if (scan2.hasNextLine()) {
                    line = scan2.nextLine();
                }else{
                    break;
                }
            }
        }
        //close file
        scan2.close();

        FileReader fr3 = new FileReader("day1/2/data.txt");
        Scanner scan3 = new Scanner(fr3);

        while (scan3.hasNextLine()) {

            //read first line
            line = scan3.nextLine();

            if (inventory > top3 && inventory != top1 && inventory != top2) {
                top3 = inventory;
            }

            inventory = 0;
            //One inventory
            while (line.length() > 0) {
                inventory += Integer.parseInt(line);
                if (scan3.hasNextLine()) {
                    line = scan3.nextLine();
                }else{
                    break;
                }
            }
        }

        //close file
        scan3.close();

        System.out.println(top1 + top2 + top3);
    }
}