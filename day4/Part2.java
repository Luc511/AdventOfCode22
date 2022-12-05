import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fl = new FileReader("/Users/lucasbalon/Documents/VSCode/AdventOfCode22/day4/data.txt");
        Scanner scan = new Scanner(fl);
        String line;
        int section11 = 0;
        int section12 = 0;
        int section21 = 0;
        int section22 = 0;
        int[] interval1;
        int[] interval2;
        int count = 0;

        while (scan.hasNextLine()) {
            line = scan.nextLine();
            section11 = Integer.parseInt(line.substring(0, line.indexOf('-')));
            section12 = Integer.parseInt(line.substring(line.indexOf('-')+1, line.indexOf(',')));
            section21 = Integer.parseInt(line.substring(line.indexOf(',')+1, line.indexOf('-', line.indexOf(','))));
            section22 = Integer.parseInt(line.substring(line.indexOf('-', line.indexOf(','))+1));
            interval1 = createInterval(section11, section12);
            interval2 = createInterval(section21, section22);

            outer:
            for (int i : interval1) {
                for (int j : interval2) {
                    if (i == j) {
                        count++;
                        break outer;
                    }
                }
            }
        }
        scan.close();
        System.out.println(count);
    }

    public static int[] createInterval(int section1, int section2) {
        int[] interval = new int[section2 - section1 + 1];
        int j = 0;
        for (int i = section1; j < interval.length; i++) {
            interval[j] = i;
            j++;
        }
        return interval;
    }
}