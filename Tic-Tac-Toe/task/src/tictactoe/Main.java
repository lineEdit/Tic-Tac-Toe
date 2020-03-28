package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Input input = Input.getInstance();
        input.logOff();
        char[] chars = input.getString("Enter cells: ").toCharArray();

        Games games = new Games();
        games.show(chars);
    }
}
