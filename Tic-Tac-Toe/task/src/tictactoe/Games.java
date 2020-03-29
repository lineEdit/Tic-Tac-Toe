package tictactoe;

public class Games {
    char[] chars;
    int move;

    public Games(String string) {
        this.chars = string.toCharArray();
        this.move = 0;
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
            String[] strSplit = input.getString("Enter the coordinates: ").split(" ");
            try {
                int row = Integer.parseInt(strSplit[0]);
                int column = Integer.parseInt(strSplit[1]);
                if (1 > row || row > 3 || 1 > column || column > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    int index = remapCoordinates(row, column);
                    if (chars[index] == '_') {
                        if (move % 2 == 0) {
                            chars[index] = 'X';
                        } else {
                            chars[index] = 'O';
                        }
                        ++move;
                        show();
                        break;
                    } else {
                        Input.sout("This cell is occupied! Choose another one!");
                    }
                }
            } catch (NumberFormatException e) {
                Input.sout("You should enter numbers!");
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
        Input.sout(outString);
    }

    private boolean isImpossible() {
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
        return isWinner('X') && isWinner( 'O');
    }

    private boolean isRow(char c) {
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

    private boolean isColumn(char c) {
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

    private boolean isDiag(char c) {
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

    private boolean isWinner(char c) {
        return isRow(c)
                || isColumn(c)
                || isDiag(c);
    }

    private boolean isEmtyCells() {
        for (char item : chars) {
            if (item == '_') {
                return true;
            }
        }
        return false;
    }

    public boolean isGameEnd() {
        if (isImpossible()) {
            Input.sout("Impossible");
            return true;
        }
        if (isWinner('X')) {
            Input.sout("X wins");
            return true;
        }
        if (isWinner('O')) {
            Input.sout("O wins");
            return true;
        }
        if (!isEmtyCells() || move >= 9) {
            Input.sout("Draw");
            return true;
        }
        return false;
    }
}
