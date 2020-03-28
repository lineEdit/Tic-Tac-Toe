package tictactoe;

import java.text.ParseException;

public class Games {
    char[][] matrix;

    public Games(String string) {
        this.matrix = new char[3][3];
        for (int i = 0; i < string.length(); ++i) {
            int[] rc = remapCoordinates(i);
            matrix[rc[0]][rc[1]] = string.charAt(i);
        }
    }

    private int[] remapCoordinates(int index) {
        int[] rc = new int[2];
//        rc - row column

        switch (index) {
            case 0: rc[0] = 1; rc[1] = 3; break;
            case 1: rc[0] = 2; rc[1] = 3; break;
            case 2: rc[0] = 3; rc[1] = 3; break;
            case 3: rc[0] = 1; rc[1] = 2; break;
            case 4: rc[0] = 2; rc[1] = 2; break;
            case 5: rc[0] = 3; rc[1] = 2; break;
            case 6: rc[0] = 1; rc[1] = 1; break;
            case 7: rc[0] = 2; rc[1] = 1; break;
            case 8: rc[0] = 3; rc[1] = 1; break;
        }

        return rc;
    }

    private int remapCoordinates(int row, int column) {
        int index = -1;

        if (row == 1) {
            switch (column) {
                case 1: index = 6; break;
                case 2: index = 3; break;
                case 3: index = 0; break;
            }
        }
        if (row == 2) {
            switch (column) {
                case 1: index = 7; break;
                case 2: index = 4; break;
                case 3: index = 1; break;
            }
        }
        if (row == 3) {
            switch (column) {
                case 1: index = 8; break;
                case 2: index = 5; break;
                case 3: index = 2; break;
            }
        }

        return index;
    }
    
    public void enterCoordinates() {
        while (true) {
            Input input = Input.getInstance();
            input.sout("Enter the coordinates: ");
            int row = 0;
            int column = 0;
            String str = input.getString();
            String[] strSplit = str.split(" ");
            try {
                row = Integer.parseInt(strSplit[0]);
                column = Integer.parseInt(strSplit[1]);
                if (1 < row || row > 3 || 1 < column || column > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } catch (NumberFormatException e) {
                input.sout("You should enter numbers!");
            }

         }
    }

    public void show() {
        String outString = String.format(
                "---------\n" +
                        "| %c %c %c |\n" +
                        "| %c %c %c |\n" +
                        "| %c %c %c |\n" +
                        "---------"
                ,matrix[0][0]
                ,matrix[1][0]
                ,matrix[2][0]
                ,matrix[0][1]
                ,matrix[1][1]
                ,matrix[2][1]
                ,matrix[0][2]
                ,matrix[1][2]
                ,matrix[2][2]
        );
        Input.sout(outString);
    }

    private boolean isImpossible(char[] chars) {
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
        return isWinner(chars, 'X') && isWinner(chars, 'O');
    }

    private boolean isRow(char[] chars, char c) {
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

    private boolean isColumn(char[] chars, char c) {
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

    private boolean isDiag(char[] chars, char c) {
        if (
                chars[0] == c &&
                        chars[4] == c &&
                        chars[8] == c
        ) {
            return true;
        }
        return chars[2] == c &&
                chars[4] == c &&
                chars[6] == c;
    }

    private boolean isWinner(char[] chars, char c) {
        return isRow(chars, c)
                || isColumn(chars, c)
                || isDiag(chars, c);
    }

    private boolean isEmtyCells(char[] chars) {
        for (char item : chars) {
            if (item == '_') {
                return true;
            }
        }
        return false;
    }

    public void stateGame(char[] chars) {
        if (isImpossible(chars)) {
            Input.sout("Impossible");
            return;
        }
        if (isWinner(chars, 'X')) {
            Input.sout("X wins");
            return;
        }
        if (isWinner(chars, 'O')) {
            Input.sout("O wins");
            return;
        }
        if (isEmtyCells(chars)) {
            Input.sout("Game not finished");
        } else {
            Input.sout("Draw");
        }
    }
}
