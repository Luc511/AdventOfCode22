package day2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fl = new FileReader("day2/data.txt");
        Scanner scan = new Scanner(fl);
        String line;
        int score = 0;

        while (scan.hasNextLine()) {
            line = scan.nextLine();
            score += calculateScore(line);
        }
        scan.close();
        System.out.println(score);
    }
    private static int calculateScore(String round) {
    int score = 0;
    char ch[] = round.toCharArray();
    char me = ch[2];
    char elf = ch[0];

    switch (me) {
        case 'X':
            score += 1;
            break;

        case 'Y':
            score += 2;
            break;

        case 'Z':
            score += 3;
            break;
            
        default:
            break;
    }
    if ((me == 'X' && elf == 'C') || (me == 'Y' && elf == 'A') || (me == 'Z' && elf == 'B')) {
        score += 6;
    }else if ((me == 'X' && elf == 'A') || (me == 'Y' && elf == 'B') || (me == 'Z' && elf == 'C')) {
        score += 3;
    }
    return score;
    }
}
