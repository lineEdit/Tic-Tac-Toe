package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner("XXXOO__O_");
        System.out.println("Enter cells: ");
        char[] chars = scanner.next().toCharArray();
        show(chars);
        stateGame(chars);
    }

    private static void show(char[] chars) {
        String outString = String.format(
                "---------\n" +
                "| %c %c %c |\n" +
                "| %c %c %c |\n" +
                "| %c %c %c |\n" +
                "---------"
                ,chars[0]
                ,chars[1]
                ,chars[2]
                ,chars[3]
                ,chars[4]
                ,chars[5]
                ,chars[6]
                ,chars[7]
                ,chars[8]
        );
        System.out.println(outString);
    }

    public static void stateGame(char[] chars) {
        int[] xRow = new int[3];
        int[] oRow = new int[3];
        int[] zRow = new int[3];
        for (int i = 0; i < 3; ++i) {
            for (int j = i * 3; j < (i + 1) * 3; ++j) {
                if (chars[j] == 'X') {
                    xRow[i]++;
                }
                if (chars[j] == 'O') {
                    oRow[i]++;
                }
                if (chars[j] == '_') {
                    zRow[i]++;
                }
            }
        }
    }
}
