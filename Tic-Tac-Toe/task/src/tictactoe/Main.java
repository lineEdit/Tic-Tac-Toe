package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

    private static boolean isImpossible(char[] chars) {
        int xCount = 0;
        int oCount = 0;
        for (char item : chars) {
            if (item == 'X') {
                ++xCount;
            }
            if (item == 'O') {
                ++oCount;
            }
        }
        if (Math.abs(xCount - oCount) > 1) {
            return true;
        }
        return false;
    }

    private static boolean isRow(char[] chars, char c) {
        for (int i = 0; i < 3; ++i) {
            if (
                    chars[i] == c &&
                    chars[i+3] == c &&
                    chars[i+6] == c
            ) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColumn(char[] chars, char c) {
        for (int i = 0; i < 3; ++i) {
            if (
                    chars[i*3] == c &&
                    chars[i*3+1] == c &&
                    chars[i*3+2] == c
            ) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiag(char[] chars, char c) {
        if (
                chars[0] == c &&
                chars[4] == c &&
                chars[8] == c
        ) {
            return true;
        }
        if (
                chars[2] == c &&
                chars[4] == c &&
                chars[6] == c
        ) {
            return true;
        }
        return false;
    }

    private static boolean isWinsExist (char[] chars) {
        if (isRow(chars, 'X')) {
            System.out.println("X wins");
            return true;
        }
        if (isRow(chars, 'O')) {
            System.out.println("O wins");
            return true;
        }
        if (isColumn(chars, 'X')) {
            System.out.println("X wins");
            return true;
        }
        if (isColumn(chars, 'O')) {
            System.out.println("O wins");
            return true;
        }
        if (isDiag(chars, 'X')) {
            System.out.println("X wins");
            return true;
        }
        if (isDiag(chars, 'O')) {
            System.out.println("O wins");
            return true;
        }
        return false;
    }

    private static boolean isEmtyCells(char[] chars) {
        for (char item : chars) {
            if (item == '_') {
                return true;
            }
        }
        return false;
    }

    public static void stateGame(char[] chars) {
        if (isImpossible(chars)) {
            System.out.println("Impossible");
            return;
        }
        if (isWinsExist(chars)) {
            return;
        }
        if (isEmtyCells(chars)) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }
}
