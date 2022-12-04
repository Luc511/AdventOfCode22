package day3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fl = new FileReader("/Users/lucasbalon/Documents/VSCode/AdventOfCode22/day3/data.txt");
        Scanner scan = new Scanner(fl);
        String line1;
        String line2;
        String line3;
        int priority = 0;

        while (scan.hasNextLine()) {
            line1 = scan.nextLine();
            line2 = scan.nextLine();
            line3 = scan.nextLine();
            for (int i = 0; i < line1.length(); i++) {
                char search = line1.charAt(i);
                if (line2.indexOf(search) != -1 && line3.indexOf(search) != -1) {
                    if ((int) search > 96 && (int) search < 123) {
                        priority += ((int) search) - 96;
                        break;
                    }else{
                        priority += ((int) search) - 38;
                        break;
                    }
                }
            }
        }
        scan.close();
        System.out.println(priority);
    }
    
}
