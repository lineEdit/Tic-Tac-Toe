package tictactoe;

public class Games {
    public void enterCoordinates(int row, int column) {
//        while (true) {
//            System.out.println("Enter the coordinates: ");
//            int row = 0;
//            int column = 0;
//            if (scanner.hasNextInt() && scanner.hasNextInt()) {
//                row = scanner.nextInt();
//                column = scanner.nextInt();
//                if (1 < row || row > 3 || 1 < column || column > 3) {
//                    System.out.println("Coordinates should be from 1 to 3!");
//                }
//            } else {
//                System.out.println("You should enter numbers!");
//            }
//            if (matrix[row][column] != '_') {
//                System.out.println("This cell is occupied! Choose another one!");
//            } else {
//
//            }
//        }
    }

    public void show(char[] chars) {
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