import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fl = new FileReader("/Users/lucasbalon/Documents/VSCode/AdventOfCode22/day5/data.txt");
        Scanner scan = new Scanner(fl);
        String line;
        int base = -1;
        int destination = -1;
        int number = -1;
        char[] temp = new char[57];
        char[][] stack = new char[9][57];
        for (int i = 0; i < stack.length; i++) {
            Arrays.fill(stack[i], 'a');
        }
        

        stack[0][0]='B';
        stack[0][1]='G';
        stack[0][2]='S';
        stack[0][3]='C';

        stack[1][0]='T';
        stack[1][1]='M';
        stack[1][2]='W';
        stack[1][3]='H';
        stack[1][4]='J';
        stack[1][5]='N';
        stack[1][6]='V';
        stack[1][7]='G';

        stack[2][0]='M';
        stack[2][1]='Q';
        stack[2][2]='S';

        stack[3][0]='B';
        stack[3][1]='S';
        stack[3][2]='L';
        stack[3][3]='T';
        stack[3][4]='W';
        stack[3][5]='N';
        stack[3][6]='M';

        stack[4][0]='J';
        stack[4][1]='Z';
        stack[4][2]='F';
        stack[4][3]='T';
        stack[4][4]='V';
        stack[4][5]='G';
        stack[4][6]='W';
        stack[4][7]='P';

        stack[5][0]='C';
        stack[5][1]='T';
        stack[5][2]='B';
        stack[5][3]='G';
        stack[5][4]='Q';
        stack[5][5]='H';
        stack[5][6]='S';

        stack[6][0]='T';
        stack[6][1]='J';
        stack[6][2]='P';
        stack[6][3]='B';
        stack[6][4]='W';

        stack[7][0]='G';
        stack[7][1]='D';
        stack[7][2]='C';
        stack[7][3]='Z';
        stack[7][4]='F';
        stack[7][5]='T';
        stack[7][6]='Q';
        stack[7][7]='M';

        stack[8][0]='N';
        stack[8][1]='S';
        stack[8][2]='H';
        stack[8][3]='B';
        stack[8][4]='P';
        stack[8][5]='F';



        while (scan.hasNextLine()) {
            line = scan.nextLine();
            number =Integer.parseInt(line.substring(5, line.indexOf('f')-1));
            base = Integer.parseInt(line.substring(line.indexOf('m', 9)+2, line.indexOf('t')-1));
            destination = Integer.parseInt(line.substring(line.indexOf('o', 12)+2));
            Arrays.fill(temp, 'a');
            int tempCount = 0;

            for (int i = 0; i < stack.length; i++) {
                if (base == i+1) {
                    for (int j = 0; j < stack[i].length; j++) {
                        if (stack[i][j] == 'a') {
                            for (int k = j-1; tempCount < number; k--) {
                                temp[tempCount] = stack[i][k];
                                stack[i][k] = 'a';
                                tempCount++;
                            }
                        }
                    }
                }
            }
            tempCount = 0;
            for (int i = 0; i < stack.length; i++) {
                if (destination == i+1) {
                    for (int j = 0; j < stack[i].length; j++) {
                        if (stack[i][j] == 'a') {
                            for (int k = j; tempCount < number; k++) {
                                stack[i][k] = temp[number];
                                number--;
                            }
                            break;
                        }
                    }
                }
            }


        }

        scan.close();
        for (int i = 0; i < stack.length; i++) {
            for (int j = 0; j < stack[i].length; j++) {
                if (stack[i][j] == 'a') {
                    System.out.print(stack[i][j-1]);
                    break;
                }
            }
        }
        System.out.println();
    }
}