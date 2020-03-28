package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cells: ");
        String string = scanner.next();
        String outString = String.format(
                "---------\n" +
                "| %c %c %c |\n" +
                "| %c %c %c |\n" +
                "| %c %c %c |\n" +
                "---------"
                ,string.charAt(0)
                ,string.charAt(1)
                ,string.charAt(2)
                ,string.charAt(3)
                ,string.charAt(4)
                ,string.charAt(5)
                ,string.charAt(6)
                ,string.charAt(7)
                ,string.charAt(8)
        );
        System.out.println(outString);
    }
}
