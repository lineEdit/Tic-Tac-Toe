package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cells: ");
        char[] chars = scanner.next().toCharArray();
        show(chars);
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
}
