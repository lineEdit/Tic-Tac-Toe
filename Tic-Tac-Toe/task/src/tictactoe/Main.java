package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cells: ");
        String string = scanner.next();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---------\n");
        stringBuilder.append("|\t");
        stringBuilder.append(string, 0, 3);
        stringBuilder.append("\t|\n");
        stringBuilder.append("|\t");
        stringBuilder.append(string, 3, 6);
        stringBuilder.append("\t|\n");
        stringBuilder.append("|\t");
        stringBuilder.append(string, 6, 9);
        stringBuilder.append("\t|\n");
        stringBuilder.append("---------");
        System.out.println(stringBuilder.toString());
    }
}
