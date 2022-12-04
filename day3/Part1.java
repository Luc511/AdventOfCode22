package day3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fl = new FileReader("/Users/lucasbalon/Documents/VSCode/AdventOfCode22/day3/data.txt");
        Scanner scan = new Scanner(fl);
        String line;
        int lineLength = 0;
        int priority = 0;
        String firstHalf;
        String secondHalf;


        while (scan.hasNextLine()) {
            line = scan.nextLine();
            lineLength = line.length();
            firstHalf = line.substring(0, lineLength/2);
            secondHalf = line.substring(lineLength/2, lineLength);
            for (int i = 0; i < lineLength/2; i++) {
                char search = firstHalf.charAt(i);
                if (secondHalf.indexOf(search) != -1) {
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