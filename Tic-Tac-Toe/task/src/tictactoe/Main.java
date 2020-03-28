package tictactoe;

public class Main {
    public static void main(String[] args) {
        Input input = Input.getInstance();
        input.logOff();
        Games games = new Games(input.getString("Enter cells: "));
        games.show();
    }
}
