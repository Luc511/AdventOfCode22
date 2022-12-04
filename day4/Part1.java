

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fl = new FileReader("/Users/lucasbalon/Documents/VSCode/AdventOfCode22/day4/data.txt");
        Scanner scan = new Scanner(fl);
        String line;
        int section11 = 0;
        int section12 = 0;
        int section21 = 0;
        int section22 = 0;
        int count = 0;

        while (scan.hasNextLine()) {
            line = scan.nextLine();
            section11 = Integer.parseInt(line.substring(0, line.indexOf('-')));
            section12 = Integer.parseInt(line.substring(line.indexOf('-')+1, line.indexOf(',')));
            section21 = Integer.parseInt(line.substring(line.indexOf(',')+1, line.indexOf('-', line.indexOf(','))));
            section22 = Integer.parseInt(line.substring(line.indexOf('-', line.indexOf(','))+1));

            if ((section11 <= section21 && section12 >= section22) || (section11 >= section21 && section12 <= section22)) {
                count++;
            }
        }
        scan.close();
        System.out.println(count);
    }
}